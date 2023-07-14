package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.ApiResponse
import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.activity.main.MainResponse
import com.example.pet_coctails.features.auth.data.CocktailsApiService.ListCocktailsResponse
import com.example.pet_coctails.features.auth.domain.model.CocktailsListRequest
import com.example.pet_coctails.features.auth.domain.model.CocktailsListResponse
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsRepository
import javax.inject.Inject

class CocktailsRepositoryImpl @Inject constructor(
    private val cocktailsNetworkDataSource: CocktailsNetworkDataSource,
    private val localDataSource: CocktailsLocalDataSource
) : CocktailsRepository {
    
    override suspend fun cocktailsList(): ListCocktailsResponse {
        return cocktailsNetworkDataSource.cocktailsList()
    }
    
}