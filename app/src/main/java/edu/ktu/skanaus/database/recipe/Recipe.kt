package edu.ktu.skanaus.database.recipe

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    var name: String,
    var cookTimeEstimateInMinutes: Int,
    var prepTimeEstimateInMinutes: Int,
    var description: String,
    var servings: Int,
    var calories: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)