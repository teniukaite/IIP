package edu.ktu.skanaus.ui.recipe.instructions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.ktu.skanaus.database.instruction.InstructionDao

/**
 * Provides the InstructionDao and recipeId to the ViewModel.
 */
class RecipeInstructionsViewModelFactory(private val dataSource: InstructionDao,
                                         private val recipeId: Long)
    : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeInstructionsViewModel::class.java)) {
            return RecipeInstructionsViewModel(dataSource, recipeId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}