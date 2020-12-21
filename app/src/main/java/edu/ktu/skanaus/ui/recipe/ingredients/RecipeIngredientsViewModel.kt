package edu.ktu.skanaus.ui.recipe.ingredients

import androidx.lifecycle.ViewModel
import edu.ktu.skanaus.database.ingredient.IngredientDao

class RecipeIngredientsViewModel(val database: IngredientDao, val recipeId: Long) : ViewModel() {
    val ingredients = database.getRecipeIngredients(recipeId)
}