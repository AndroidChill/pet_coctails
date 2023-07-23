package com.example.pet_coctails.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity (tableName = "cocktails",
    indices = [Index("id")])
data class CocktailsDataEntity(
    @PrimaryKey (autoGenerate = true) val id: Long,
    @ColumnInfo (name = "id_cocktail") val idCocktail: String
)
