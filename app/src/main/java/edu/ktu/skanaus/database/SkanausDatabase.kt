package edu.ktu.skanaus.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ktu.skanaus.database.ingredient.Ingredient
import edu.ktu.skanaus.database.ingredient.IngredientDao
import edu.ktu.skanaus.database.instruction.Instruction
import edu.ktu.skanaus.database.instruction.InstructionDao
import edu.ktu.skanaus.database.recipe.Recipe
import edu.ktu.skanaus.database.recipe.RecipeDao

@Database(
    entities = [Recipe::class, Ingredient::class, Instruction::class], version = 1, exportSchema = false)
abstract class SkanausDatabase : RoomDatabase() {

    abstract val recipeDao: RecipeDao
    abstract val ingredientDao: IngredientDao
    abstract val instructionDao: InstructionDao
    abstract val searchDao: SearchDao

    companion object {

        @Volatile
        private var INSTANCE: SkanausDatabase? = null


        fun getInstance(context: Context): SkanausDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SkanausDatabase::class.java,
                        "recipe_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}