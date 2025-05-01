package com.example.cucinafacileapp.network

import com.example.cucinafacileapp.models.Recipe
import retrofit2.http.GET

interface RecipeApi {
    @GET("api/recipe")
    suspend fun getAllRecipes(): List<Recipe>
}
