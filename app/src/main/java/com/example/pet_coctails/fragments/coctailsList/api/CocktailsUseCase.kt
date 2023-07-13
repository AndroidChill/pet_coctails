package com.example.pet_coctails.fragments.coctailsList.api

import com.example.pet_coctails.core.scope.FeatureScope
import javax.inject.Inject

@FeatureScope
class CocktailsUseCase @Inject constructor(private val repository: CocktailsRepository) {
}