package com.example.pet_coctails.fragments

import com.example.pet_coctails.features.auth.data.CocktailResponse
import com.example.pet_coctails.features.auth.data.ListCocktailsResponse

interface CocktailsRepository {

    suspend fun cocktailsList(): ListCocktailsResponse

    suspend fun cocktailInfo(): CocktailResponse
}