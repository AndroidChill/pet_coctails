package com.example.pet_coctails.fragments

import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.dataBase.CocktailsDataEntity
import com.example.pet_coctails.features.auth.data.CocktailResponse
import com.example.pet_coctails.features.auth.data.ListCocktailsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@FeatureScope
class CocktailsUseCase @Inject constructor(private val repository: CocktailsRepository) {
    
    
    
    suspend fun cocktailsList(): ListCocktailsResponse = repository.cocktailsList()
    suspend fun cocktailInfo(id: String): CocktailSum = repository.cocktailInfo(id)

    suspend fun cocktailRandom(): CocktailSum? = repository.cocktailRandom()
    
//    suspend fun insertNewCocktailData(entity: CocktailsDataEntity) = repository.insertNewCocktailData(entity)
}