package com.example.pet_coctails.fragments

import com.example.pet_coctails.dataBase.CocktailsDataEntity
import com.example.pet_coctails.features.auth.data.ListCocktailsResponse
import kotlinx.serialization.Serializable

interface CocktailsRepository {
    
    
//    suspend fun insertNewCocktailData(entity: CocktailsDataEntity): Long
    
    suspend fun cocktailsList(): ListCocktailsResponse
    suspend fun cocktailRandom(): CocktailSum?

    suspend fun cocktailInfo(id: String): CocktailSum

}

data class CocktailSum(
    val name: String = "",
    val category: String = "",
    val cocktailType: String = "",
    val glass: String = "",
    val instruction: String = "",
    val imageLink: String = "",
    val some: List<CocktailClear> = emptyList(),
)

@Serializable
data class CocktailClear(
    val ingredient: String,
    val measure: String?
)