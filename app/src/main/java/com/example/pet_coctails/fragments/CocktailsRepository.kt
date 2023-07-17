package com.example.pet_coctails.fragments

import com.example.pet_coctails.features.auth.data.Cocktail
import com.example.pet_coctails.features.auth.data.CocktailResponse
import com.example.pet_coctails.features.auth.data.ListCocktailsResponse

interface CocktailsRepository {

    suspend fun cocktailsList(): ListCocktailsResponse

    suspend fun cocktailInfo(id: String): CocktailSumm

}

data class CocktailSumm(
    val name: String,
    val category: String,
    val glass: String,
    val some: List<CocktailClear>,
)

data class CocktailClear(
    val ingridient: String,
    val measure: String?
)