package com.example.mealsdb

import androidx.room.Database
import androidx.room.RoomDatabase
//Room database for storing and accessing data related to meals.
@Database(entities = [Meals::class], version = 1)//the database will contain data of the Meals class.
abstract class MealsDatabase: RoomDatabase() {// extends RoomDatabase,This class is the main entry point for interacting with the database
    abstract fun mealsDao(): MealsDAO //returns a meal DAO object
}