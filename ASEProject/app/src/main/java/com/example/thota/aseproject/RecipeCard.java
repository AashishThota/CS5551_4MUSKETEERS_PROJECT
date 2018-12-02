package com.example.thota.aseproject;

import java.util.List;

public class RecipeCard {
    public String getTitle() {
        return title;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getNumofppl() {
        return numofppl;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getTime() {
        return time;
    }

    String title;
    String instructions;
    String numofppl;
    List<String> ingredients;
    String time;


    public RecipeCard() {
    }

    public RecipeCard(String title, String instructions, String numofppl, List<String> ingredients,String time) {
        this. title= title;
        this.instructions = instructions;
        this.numofppl = numofppl;
        this.time=time;
        this.ingredients=ingredients;
    }


}