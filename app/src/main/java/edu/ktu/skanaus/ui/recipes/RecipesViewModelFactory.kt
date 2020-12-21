package edu.ktu.skanaus.ui.recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.ktu.skanaus.database.SearchDao
import edu.ktu.skanaus.database.recipe.RecipeDao

/**
 * Provides the RecipeDao to the ViewModel.
 */
class RecipesViewModelFactory(private val recipeDao: RecipeDao, private val searchDao: SearchDao)
    : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipesViewModel::class.java)) {
            return RecipesViewModel(recipeDao, searchDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}