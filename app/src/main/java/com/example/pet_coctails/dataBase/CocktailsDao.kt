package com.example.pet_coctails.dataBase

import androidx.room.Insert
import androidx.room.Query

interface CocktailsDao {
    @Insert(entity = CocktailsDataEntity::class)
    fun insertNewCocktailData(statistic: CocktailsDataEntity)

    @Query("SELECT cocktails.id, id_cocktail FROM cocktails\n")
    fun getCocktailData(): List<CocktailsTuple>

    @Query("DELETE FROM cocktails WHERE id = :cocktailsId")
    fun deleteCocktailDataById(cocktailsId: Long)
}