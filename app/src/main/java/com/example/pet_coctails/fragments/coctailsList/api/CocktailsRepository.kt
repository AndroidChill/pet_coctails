package com.example.pet_coctails.fragments.coctailsList.api

import com.example.pet_coctails.features.auth.data.ListCocktailsResponse

interface CocktailsRepository {

    suspend fun cocktailsList(): ListCocktailsResponse
}