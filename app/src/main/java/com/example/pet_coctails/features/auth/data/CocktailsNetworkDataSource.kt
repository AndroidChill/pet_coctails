package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsApiService
import javax.inject.Inject

@FeatureScope
class CocktailsNetworkDataSource @Inject constructor(
    private val cocktailsApiService: CocktailsApiService
) {

    suspend fun cocktailsList () = cocktailsApiService.getListCocktails()

}