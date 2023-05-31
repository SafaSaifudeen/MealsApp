package com.example.mealsdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SearchForMeals : AppCompatActivity() {
    // Declare variables for the UI elements
    private var searchBox: EditText? = null
    private var searchBtn: Button? = null
    private var resultsBox: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_for_meals)
        // Find the UI elements by their IDs
        searchBox = findViewById(R.id.search)
        searchBtn = findViewById(R.id.button4)
        resultsBox = findViewById(R.id.results)

        searchBtn?.setOnClickListener {
            searchforMealsFromDB()
        }
    }
    private fun searchforMealsFromDB() {
        // Access the database
        val db = Room.databaseBuilder(this, MealsDatabase::class.java, "MealDB").build()
        val mealDao = db.mealsDao()
        // Get the search query from the search box and clean it up

        val meal = searchBox!!.text.toString().lowercase().trim()
        if (meal == ""){
            return
        }

        runBlocking {
            launch {
                var mealTitles = ""

                val meals =  mealDao.getAllTitles(meal)
                // println(meals)

                // Loop through the list of meals and concatenate their titles into a string

                for( x in meals){
                    mealTitles += x.meal.toString()
                    mealTitles += "\n"
                }
                // Set the results text box to display the meal titles
                resultsBox?.text = mealTitles
            }
        }
    }

}