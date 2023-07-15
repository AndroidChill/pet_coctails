package com.example.pet_coctails.fragments.coctailsList.api

import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.features.auth.data.ListCocktailsResponse
import javax.inject.Inject

@FeatureScope
class CocktailsUseCase @Inject constructor(private val repository: CocktailsRepository) {
    suspend fun cocktailsList(): ListCocktailsResponse = repository.cocktailsList()
}