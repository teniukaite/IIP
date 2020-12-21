package edu.ktu.skanaus.ui.recipe.instructions

import androidx.lifecycle.ViewModel
import edu.ktu.skanaus.database.instruction.InstructionDao

class RecipeInstructionsViewModel(val database: InstructionDao, val recipeId: Long) : ViewModel() {
    val instructions = database.getRecipeInstructions(recipeId)
}