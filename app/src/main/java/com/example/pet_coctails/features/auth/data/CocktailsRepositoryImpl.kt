package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.fragments.CocktailClear
import com.example.pet_coctails.fragments.CocktailSumm
import com.example.pet_coctails.fragments.CocktailsRepository
import javax.inject.Inject

class CocktailsRepositoryImpl @Inject constructor(
    private val cocktailsNetworkDataSource: CocktailsNetworkDataSource
) : CocktailsRepository {

    override suspend fun cocktailsList(): ListCocktailsResponse {
        return cocktailsNetworkDataSource.cocktailsList()
    }

    override suspend fun cocktailInfo(id: String): CocktailSumm {
        val cocktail = cocktailsNetworkDataSource.cocktailInfo(id).drinks.first()
        val data = mutableListOf<CocktailClear>()
        
        if (cocktail.strIngredient1 != null) {
            data.add(CocktailClear(ingridient = cocktail.strIngredient1, measure = cocktail.strMeasure1))
        }
        
        return CocktailSumm(
            some = data,
            name = cocktail.strDrink,
            category = cocktail.strCategory,
            glass = cocktail.strGlass
        )
    }


}