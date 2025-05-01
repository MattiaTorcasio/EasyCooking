package com.example.cucinafacileapp.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import com.example.cucinafacileapp.models.Recipe;

public interface RecipeApi {
    @GET("api/recipe")
    Call<List<Recipe>> getAllRecipes();
}
