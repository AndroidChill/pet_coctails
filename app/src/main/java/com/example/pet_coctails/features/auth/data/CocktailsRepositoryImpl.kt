package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.dataBase.CocktailsDataEntity
import com.example.pet_coctails.fragments.CocktailClear
import com.example.pet_coctails.fragments.CocktailSum
import com.example.pet_coctails.fragments.CocktailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CocktailsRepositoryImpl @Inject constructor(
    private val cocktailsNetworkDataSource: CocktailsNetworkDataSource,
//    private val cocktailsLocalDataSource: CocktailsLocalDataSource
) : CocktailsRepository {
    
//    override suspend fun insertNewCocktailData(entity: CocktailsDataEntity): Long {
//        return cocktailsLocalDataSource.insertNewCocktailData(entity)
//    }
    
    override suspend fun cocktailsList(): ListCocktailsResponse {
        return cocktailsNetworkDataSource.cocktailsList()
    }

    override suspend fun cocktailRandom(): CocktailSum? {
        return cocktailsNetworkDataSource.cocktailRandom().toCocktailSum()
    }

    override suspend fun cocktailInfo(id: String): CocktailSum {
        val cocktail = cocktailsNetworkDataSource.cocktailInfo(id).drinks.first()
        val data = mutableListOf<CocktailClear>()
        
        if (cocktail.strIngredient1 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient1, measure = cocktail.strMeasure1))
        }
        if (cocktail.strIngredient2 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient2, measure = cocktail.strMeasure2))
        }
        if (cocktail.strIngredient3 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient3, measure = cocktail.strMeasure3))
        }
        if (cocktail.strIngredient4 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient4, measure = cocktail.strMeasure4))
        }
        if (cocktail.strIngredient5 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient5, measure = cocktail.strMeasure5))
        }
        if (cocktail.strIngredient6 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient6, measure = cocktail.strMeasure6))
        }
        if (cocktail.strIngredient7 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient7, measure = cocktail.strMeasure7))
        }
        if (cocktail.strIngredient8 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient8, measure = cocktail.strMeasure8))
        }
        if (cocktail.strIngredient9 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient9, measure = cocktail.strMeasure9))
        }
        if (cocktail.strIngredient10 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient10, measure = cocktail.strMeasure10))
        }
        if (cocktail.strIngredient11 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient11, measure = cocktail.strMeasure11))
        }
        if (cocktail.strIngredient12 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient12, measure = cocktail.strMeasure12))
        }
        if (cocktail.strIngredient13 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient13, measure = cocktail.strMeasure13))
        }
        if (cocktail.strIngredient14 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient14, measure = cocktail.strMeasure14))
        }
        if (cocktail.strIngredient15 != null) {
            data.add(CocktailClear(ingredient = cocktail.strIngredient15, measure = cocktail.strMeasure15))
        }

        return CocktailSum(
            some = data,
            imageLink = cocktail.strDrinkThumb,
            name = cocktail.strDrink,
            cocktailType = cocktail.strAlcoholic,
            category = cocktail.strCategory,
            glass = cocktail.strGlass,
            instruction = cocktail.strInstructions
        )
    }


}