package edu.ktu.skanaus.database.ingredient

import androidx.room.Entity
import androidx.room.ForeignKey
import edu.ktu.skanaus.database.recipe.Recipe

@Entity(
    tableName = "ingredients",
    primaryKeys = ["recipeId", "orderOfIngredient"],
    foreignKeys = [
        ForeignKey(
            entity = Recipe::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Ingredient(
    var recipeId: Long,
    var description: String,
    var orderOfIngredient: Int
)