package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.core.scope.FeatureScope
import javax.inject.Inject

@FeatureScope
class CocktailsNetworkDataSource @Inject constructor(
    private val cocktailsApiService: CocktailsApiService
) {

    suspend fun cocktailsList () = cocktailsApiService.getListCocktails()
    suspend fun cocktailInfo () = cocktailsApiService.getInfo(String()) //todo не нравится ему что в ApiService есть id

}