package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.fragments.CocktailsRepository
import javax.inject.Inject

class CocktailsRepositoryImpl @Inject constructor(
    private val cocktailsNetworkDataSource: CocktailsNetworkDataSource
) : CocktailsRepository {

    override suspend fun cocktailsList(): ListCocktailsResponse {
        return cocktailsNetworkDataSource.cocktailsList()
    }

    override suspend fun cocktailInfo(): CocktailResponse {
        return cocktailsNetworkDataSource.cocktailInfo()
    }


}