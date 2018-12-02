package com.example.thota.aseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button scan,additem,upld,log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        scan=(Button)findViewById(R.id.ScanButton);
        additem=(Button)findViewById(R.id.addItem);
        upld=(Button)findViewById(R.id.upload);
        log=(Button)findViewById(R.id.logot);
        upld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent upld= new Intent(Home.this,uploadrecipe.class);
                startActivity(upld);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main= new Intent(Home.this,MainActivity.class);
                startActivity(main);
            }
        });
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scanner= new Intent(Home.this,Scan.class);
                startActivity(scanner);
            }
        });
        //we are calling the addList activity
        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addlistitem = new Intent(Home.this,addList.class);
                addlistitem.putExtra("item","");
                startActivity(addlistitem);
            }
        });
    }
}
