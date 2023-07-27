package com.example.pet_coctails.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface CocktailsDao {
    @Insert(entity = CocktailsDataEntity::class)
    fun insertNewCocktailData(entity: CocktailsDataEntity): Long

    @Query("SELECT id_cocktail FROM cocktails")
    fun getCocktailData(): List<CocktailsDataEntity>

    @Query("DELETE FROM cocktails WHERE id_cocktail = :cocktailsId")
    fun deleteCocktailDataById(cocktailsId: Long): Int
}