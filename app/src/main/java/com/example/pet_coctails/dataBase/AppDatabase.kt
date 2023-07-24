package com.example.pet_coctails.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (
    version = 2,
    entities = [
        CocktailsDataEntity::class
    ]
        )
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCocktailsDao(): CocktailsDao

}