package com.example.recipepicker;

import com.example.recipepicker.domain.ImageModel;
import com.example.recipepicker.domain.Recipe;

import java.io.File;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RecipePickerAPI {
    @GET("/all")
    Call<List<Recipe>> getRecipes();

    @GET("/image/get/id/{id}")
    Call<ImageModel> getImage(@Path("id") int id);
}
