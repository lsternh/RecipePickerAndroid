package com.example.recipepicker.domain;

import java.util.Date;
import java.util.List;

public class Recipe {
    private String name;
    private String steps;
   // private Date uploaded;
    private String url;
    private String image_dir;
    private List<Ingredient> ingredientsList;

    private int id;


    public Recipe(String name, String steps, int id, String url, String image_dir, List<Ingredient> ingredientsList){
        this.name = name;
        this.steps = steps;
       // this.uploaded = new Date();
        this.id = id;
        this.url = url;
        this.image_dir = image_dir;
        this.ingredientsList = ingredientsList;
    }

    public Recipe() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSteps() {
        return steps;
    }
    public void setSteps(String steps) {
        this.steps = steps;
    }
    //public Date getUploaded() {
    //    return uploaded;
    //}
   // public void setUploaded(Date uploaded) {
   //     this.uploaded = uploaded;
    //}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }
    public void setIngredientsList(List<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }
}
