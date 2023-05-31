package com.example.mealsdb


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface MealsDAO {// DAO interface that provides methods for accessing and manipulating data
    @Insert
    suspend fun insertAll(vararg meals: Meals)
    @Query("SELECT * FROM Meals")
    suspend fun getAll(): List<Meals>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(vararg meals: Meals)

    @Query("SELECT * FROM Meals WHERE meal LIKE '%' || :name || '%'")
    suspend fun getAllTitles(name: String): List<Meals>

    @Query("SELECT count(*) FROM Meals")
    suspend fun countAll(): Int




}