package com.example.pet_coctails.dataBase

import androidx.room.ColumnInfo

class CocktailsTuple (
    val id: Long,
    @ColumnInfo(name = "id_cocktail") val idCocktail: String
        )