package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.ApiResponse
import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.activity.main.MainResponse
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsRepository
import javax.inject.Inject

class CocktailsRepositoryImpl @Inject constructor(
    private val cocktailsNetworkDataSource: CocktailsNetworkDataSource,
    private val localDataSource: CocktailsLocalDataSource
) : CocktailsRepository {

    suspend fun main (request: MainRequest): ApiResponse <MainResponse> =
        cocktailsNetworkDataSource.cocktailsList(request).apply {
            this.data?.let{
                localDataSource.saveToken(it.token)
            }
        }
}