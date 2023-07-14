package com.example.pet_coctails.fragments.coctailsList.api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.pet_coctails.ApiResponse
import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.features.auth.domain.model.CocktailsListRequest
import com.example.pet_coctails.features.auth.domain.model.CocktailsListResponse
import javax.inject.Inject

@FeatureScope
class CocktailsUseCase @Inject constructor(private val repository: CocktailsRepository) {
    suspend fun cocktailsList(
        imageLink: Int,
        cocktailName: String,
        id: Int,
        category: String,
        cocktailType: String,
        glassType: String
    ): Flow<ApiResponse<CocktailsListResponse>> = flow {
        emit(
            repository.cocktailsList(
                CocktailsListRequest(
                    imageLink, cocktailName, id, category, cocktailType, glassType
                )
            )
        )
    }
}