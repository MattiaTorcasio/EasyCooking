package com.example.cucinafacileapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cucinafacileapp.models.Recipe
import com.example.cucinafacileapp.network.ApiClient
import com.example.cucinafacileapp.network.RecipeApi

class MainActivity : ComponentActivity() {
    private val tag = "CucinaFacile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipeScreen()
                }
            }
        }
    }

    @Composable
    fun RecipeScreen() {
        var recipes by remember { mutableStateOf<List<Recipe>>(emptyList()) }

        LaunchedEffect(true) {
            try {
                val api = ApiClient.getClient().create(RecipeApi::class.java)
                val result = api.getAllRecipes() // suspend call
                recipes = result
            } catch (e: Exception) {
                Log.e(tag, "Error loading recipes", e)
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            LazyColumn {
                items(recipes) { recipe ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFDF0D5)
                        ),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = recipe.name,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.testTag("recipe_title")
                                )

                                val flag = when (recipe.languageCode.lowercase()) {
                                    "it" -> "🇮🇹"
                                    "en" -> "🇬🇧"
                                    else -> "🌍"
                                }

                                Text(
                                    text = "$flag ${recipe.languageCode.uppercase()}",
                                    fontSize = 14.sp,
                                    color = Color(0xFF6B705C)
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = stringResource(id = R.string.ingredients),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF9C6644)
                            )

                            Text(
                                text = recipe.ingredients,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4
                            )
                        }
                    }
                }
            }
        }
    }
}
