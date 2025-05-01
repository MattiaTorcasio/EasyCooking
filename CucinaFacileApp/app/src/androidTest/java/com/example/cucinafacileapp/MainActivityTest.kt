package com.example.cucinafacileapp
import kotlinx.coroutines.delay
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun recipeList_showsAnyRecipeTitle_afterDelay() {
        Thread.sleep(1000) // just for render
        composeTestRule
            .onNodeWithTag("recipe_title")
            .assertIsDisplayed()
    }
}