package com.example.mealsdb

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
class SearchForMealsByIngredients : AppCompatActivity() {


    private lateinit var resultsBox: TextView
    private lateinit var retrieveBtn: Button
    private lateinit var searchBox: EditText
    private lateinit var saveBtn: Button



    var name: String=""
    var drinkAlternate: String=""
    var category : String=""
    var area : String=""
    var instructions : String=""
    var thumb : String=""
    var tags : String=""

    var youtube : String=""

    var ingredient1 : String=""
    var ingredient2 : String=""
    var ingredient3 : String=""
    var ingredient4 : String=""
    var ingredient5 : String=""
    var ingredient6 : String=""
    var ingredient7 : String=""
    var ingredient8 : String=""
    var ingredient9 : String=""
    var ingredient10 : String=""
    var ingredient11 : String=""
    var ingredient12: String=""
    var ingredient13 : String=""
    var ingredient14 : String=""
    var ingredient15 : String=""
    var ingredient16: String=""
    var ingredient17 : String=""
    var ingredient18 : String=""
    var ingredient19 : String=""
    var ingredient20 : String=""

    var measure1 : String=""
    var measure2 : String=""
    var measure3 : String=""
    var measure4 : String=""
    var measure5 : String=""
    var measure6 : String=""
    var measure7 : String=""
    var measure8: String=""
    var measure9 : String=""
    var measure10 : String=""
    var measure11 : String=""
    var measure12 : String=""
    var measure13 : String=""
    var measure14  : String=""
    var measure15  : String=""
    var measure16 : String=""
    var measure17 : String=""
    var measure18 : String=""
    var measure19 : String=""
    var measure20 : String=""






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_for_meals_by_ingredients)
        searchBox=findViewById(R.id.search_view_edit_text)
        saveBtn=findViewById(R.id.saveBtn)
        resultsBox=findViewById(R.id.results)
        retrieveBtn=findViewById(R.id.retrieveBtn)

        retrieveBtn.setOnClickListener{
        val search = searchBox.text.toString()
        // Constructing of  the URL with the search query
        val urlString = "https://www.themealdb.com/api/json/v1/1/search.php?s=$search"

        val url = URL(urlString)
        val con: HttpURLConnection = url.openConnection() as HttpURLConnection

            // Execute the network request in a coroutine to prevent the main thread from being blocked.
        runBlocking {
            launch {
                // Start a new thread and execute the coroutine's code.
                withContext(Dispatchers.IO) {
                    // Reading  the response from the API and store it in a StringBuilder
                    val bf = BufferedReader(InputStreamReader(con.inputStream))
                    val stb = StringBuilder()
                    var line: String? = bf.readLine()
                    while (line != null) {
                        stb.append(line + "\n")
                        line = bf.readLine()
                    }

                    // Parse the JSON response to display the details about the meal.
                    parseJSON(stb)
                }
            }


        }
        }
        saveBtn.setOnClickListener {
            SaveMeal()
        }


    }
    private fun parseJSON(stb: StringBuilder) {
        // From the answer string, create a JSON object.
        val json = JSONObject(stb.toString())

        // Take the JSON object's array of meals.
        val mealArray = json.getJSONArray("meals")

        // Construct a StringBuilder to store the meal details.
        val mealDetails = StringBuilder()
        // Looping through each meal object in the array
        for (i in 0 until mealArray.length()) {
            val mealObject = mealArray.getJSONObject(i)

            name = mealObject.getString("strMeal")
            drinkAlternate = mealObject.getString("strDrinkAlternate")
            category = mealObject.getString("strCategory")
            area = mealObject.getString("strArea")
            instructions = mealObject.getString("strInstructions")
            thumb= mealObject.getString("strMealThumb")
            tags = mealObject.getString("strTags")
            youtube = mealObject.getString("strYoutube")

             ingredient1 = mealObject.getString("strIngredient1")
             ingredient2 = mealObject.getString("strIngredient2")
             ingredient3 = mealObject.getString("strIngredient3")
             ingredient4 = mealObject.getString("strIngredient4")
             ingredient5 = mealObject.getString("strIngredient5")
             ingredient6 = mealObject.getString("strIngredient6")
             ingredient7 = mealObject.getString("strIngredient7")
             ingredient8 = mealObject.getString("strIngredient8")
             ingredient9 = mealObject.getString("strIngredient9")
             ingredient10 = mealObject.getString("strIngredient10")
             ingredient11 = mealObject.getString("strIngredient11")
             ingredient12 = mealObject.getString("strIngredient12")
             ingredient13 = mealObject.getString("strIngredient13")
             ingredient14 = mealObject.getString("strIngredient14")
             ingredient15 = mealObject.getString("strIngredient15")
             ingredient16 = mealObject.getString("strIngredient16")
             ingredient17 = mealObject.getString("strIngredient17")
             ingredient18 = mealObject.getString("strIngredient18")
             ingredient19 = mealObject.getString("strIngredient19")
             ingredient20 = mealObject.getString("strIngredient20")

             measure1 = mealObject.getString("strMeasure1")
             measure2 = mealObject.getString("strMeasure2")
             measure3 = mealObject.getString("strMeasure3")
             measure4 = mealObject.getString("strMeasure4")
             measure5 = mealObject.getString("strMeasure5")
             measure6 = mealObject.getString("strMeasure6")
             measure7 = mealObject.getString("strMeasure7")
             measure8 = mealObject.getString("strMeasure8")
             measure9 = mealObject.getString("strMeasure9")
             measure10 = mealObject.getString("strMeasure10")
             measure11 = mealObject.getString("strMeasure11")
             measure12 = mealObject.getString("strMeasure12")
             measure13 = mealObject.getString("strMeasure13")
             measure14 = mealObject.getString("strMeasure14")
             measure15 = mealObject.getString("strMeasure15")
             measure16 = mealObject.getString("strMeasure16")
             measure17 = mealObject.getString("strMeasure17")
             measure18 = mealObject.getString("strMeasure18")
             measure19 = mealObject.getString("strMeasure19")
             measure20 = mealObject.getString("strMeasure20")



            // Appending the meal information to the StringBuilder
            mealDetails.append("Meal: $name\n")
            mealDetails.append("Drink Alternate: $drinkAlternate\n")
            mealDetails.append("Category: $category\n")
            mealDetails.append("Area: $area\n")

            mealDetails.append("MealsThumb: $instructions\n")
            mealDetails.append("Instructions: $thumb\n")
            mealDetails.append("Tags: $tags\n")
            mealDetails.append("YouTube: $youtube\n")
            mealDetails.append("Ingredient1: $ingredient1\n")
            mealDetails.append("Ingredient2: $ingredient2\n")
            mealDetails.append("Ingredient3: $ingredient3\n")
            mealDetails.append("Ingredient4: $ingredient4\n")
            mealDetails.append("Ingredient5: $ingredient5\n")
            mealDetails.append("Ingredient6: $ingredient6\n")
            mealDetails.append("Ingredient7: $ingredient7\n")
            mealDetails.append("Ingredient8: $ingredient8\n")
            mealDetails.append("Ingredient9: $ingredient9\n")
            mealDetails.append("Ingredient10: $ingredient10\n")
            mealDetails.append("Ingredient11: $ingredient11\n")
            mealDetails.append("Ingredient12: $ingredient12\n")
            mealDetails.append("Ingredient13: $ingredient13\n")
            mealDetails.append("Ingredient14: $ingredient14\n")
            mealDetails.append("Ingredient15: $ingredient15\n")
            mealDetails.append("Ingredient16: $ingredient16\n")
            mealDetails.append("Ingredient17: $ingredient17\n")
            mealDetails.append("Ingredient18: $ingredient18\n")
            mealDetails.append("Ingredient19: $ingredient19\n")
            mealDetails.append("Ingredient20: $ingredient20\n")
            mealDetails.append("Measure1: $measure1\n")
            mealDetails.append("Measure2: $measure2\n")
            mealDetails.append("Measure3: $measure3\n")
            mealDetails.append("Measure4: $measure4\n")
            mealDetails.append("Measure5: $measure5\n")
            mealDetails.append("Measure6: $measure6\n")
            mealDetails.append("Measure7: $measure7\n")
            mealDetails.append("Measure8: $measure8\n")
            mealDetails.append("Measure9: $measure9\n")
            mealDetails.append("Measure10: $measure10\n")
            mealDetails.append("Measure11: $measure11\n")
            mealDetails.append("Measure12: $measure12\n")
            mealDetails.append("Measure13: $measure13\n")
            mealDetails.append("Measure14: $measure14\n")
            mealDetails.append("Measure15: $measure15\n")
            mealDetails.append("Measure16: $measure16\n")
            mealDetails.append("Measure17: $measure17\n")
            mealDetails.append("Measure18: $measure18\n")
            mealDetails.append("Measure19: $measure19\n")
            mealDetails.append("Measure20: $measure20\n\n")

        }

        runOnUiThread {
            // Display the meal information in the TextView
            resultsBox.text = mealDetails.toString()
        }
    }
    private fun SaveMeal() {
        // Accessing the database
        val db = Room.databaseBuilder(this, MealsDatabase::class.java, "MealDB").build()
        val mealDAO = db.mealsDao()

        runBlocking {
            launch{
                // Saving in the DataBase
                val meals: List<Meals> = mealDAO.getAll()
                val index = meals.size + 1
                val m = Meals(index, name, drinkAlternate, category, area, instructions, thumb ,tags, youtube, ingredient1,ingredient2,ingredient3,ingredient4,ingredient5,ingredient6, ingredient7, ingredient8, ingredient9, ingredient10, ingredient11, ingredient12, ingredient13, ingredient14, ingredient15, ingredient16, ingredient17, ingredient18, ingredient19, ingredient20, measure1, measure2, measure3, measure4, measure5, measure6, measure7, measure8, measure9, measure10, measure11, measure12, measure13, measure14, measure15, measure16, measure17, measure18, measure19, measure20)
                mealDAO.insertMeal(m)

            }
        }
    }


}