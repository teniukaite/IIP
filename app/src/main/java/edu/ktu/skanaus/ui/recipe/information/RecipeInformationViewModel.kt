package edu.ktu.skanaus.ui.recipe.information

import androidx.lifecycle.ViewModel
import edu.ktu.skanaus.database.recipe.RecipeDao

class RecipeInformationViewModel (val database: RecipeDao, val recipeId: Long) : ViewModel() {
    val recipe = database.getRecipe(recipeId)
}