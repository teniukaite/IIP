package edu.ktu.skanaus.database

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Query

@Dao
interface SearchDao {
    @Query("SELECT id as _id, name as recipeName FROM recipes WHERE name LIKE '%' || :searchInput || '%' ORDER BY id ASC")
    fun getRecipeSearchSuggestions(searchInput: String): Cursor?

    @Query("SELECT recipes.id as _id, recipes.name as recipeName, ingredients.description as ingredient FROM recipes, ingredients WHERE recipes.id = ingredients.recipeId AND ingredients.description LIKE '%' || :searchInput || '%' ORDER BY recipeId ASC")
    fun getIngredientSearchSuggestions(searchInput: String): Cursor?

    @Query("SELECT recipes.id as _id, recipes.name as recipeName, instructions.description as instruction FROM recipes, instructions WHERE recipes.id = instructions.recipeId AND instructions.description LIKE '%' || :searchInput || '%' ORDER BY recipeId ASC")
    fun getInstructionSearchSuggestions(searchInput: String): Cursor?
}