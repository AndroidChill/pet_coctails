package com.example.pet_coctails.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity (tableName = "cocktails")
data class CocktailsDataEntity(
    @PrimaryKey @ColumnInfo (name = "id_cocktail") val idCocktail: String
)