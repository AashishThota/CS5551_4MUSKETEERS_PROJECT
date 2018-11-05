package com.example.thota.aseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainRecipe extends AppCompatActivity {
    int id;
    ImageView recipeimage;
    TextView recipetitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recipe);
        Intent intent=getIntent();
        recipeimage=(ImageView)findViewById(R.id.recipeimage);
        recipetitle=(TextView)findViewById(R.id.recipetitle);
        id=intent.getIntExtra("id",0);
        if(id!=0){
            String url= "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/"+id+"/information";
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("X-Mashape-Key", "aqReKEVTCsmshkwxFbj0Onzmjxymp1UP7N0jsnkNPIxWG2YLJb")
                    .addHeader("X-Mashape-Host", "spoonacular-recipe-food-nutrition-v1.p.mashape.com")
                    .url(url)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    final String reciperesult= response.body().string();
                    try {
                        Log.d("out",reciperesult);
                        JSONObject res= new JSONObject(reciperesult);

                        String instructions= res.getString("instructions");
                        String img=res.getString("image");

                        String title=res.getString("title");
                        Log.d("title",title);
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                loadImageFromUrl(img);
                                recipetitle.setText(title);
                            }
                        });
                        if(instructions.equals(null)){

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });

        }
    }
    private void loadImageFromUrl(String img) {
        Picasso.with(MainRecipe.this).load(img).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(recipeimage,new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
