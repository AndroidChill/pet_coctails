package com.example.pet_coctails.fragments.coctailsList.api

import com.example.pet_coctails.ApiResponse
import com.example.pet_coctails.features.auth.domain.model.CocktailsListRequest
import com.example.pet_coctails.features.auth.domain.model.CocktailsListResponse

interface CocktailsRepository {

    suspend fun cocktailsList (request: CocktailsListRequest): ApiResponse<CocktailsListResponse>
}