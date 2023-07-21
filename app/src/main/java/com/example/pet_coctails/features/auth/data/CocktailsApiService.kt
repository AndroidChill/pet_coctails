package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.fragments.CocktailClear
import com.example.pet_coctails.fragments.CocktailSum
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsApiService {

    @GET("search.php?f=a")
    suspend fun getListCocktails(): ListCocktailsResponse

    @GET("lookup.php")
    suspend fun getInfo(@Query("i") id: String): CocktailResponse
    @GET("random.php")
    suspend fun getRandom(): CocktailResponse
}

data class ListCocktailsResponse(
    val drinks: List<Cocktail>
)

@Serializable
data class Cocktail(
    val strDrinkThumb: String,
    val strDrink: String,
    val idDrink: String,
    val strCategory: String,
    val strAlcoholic: String,
    val strGlass: String
)

data class CocktailResponse (
    val drinks: List <CocktailFullInfo>
        ) {
    fun toCocktailSum() : CocktailSum? {
        if (drinks.size != 1) {
            return null
        }
        val cocktail = drinks.first()
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

@Serializable
data class CocktailFullInfo(
    val strDrinkThumb: String,
    val strDrink: String,
    val idDrink: String,
    val strCategory: String,
    val strAlcoholic: String,
    val strGlass: String,
    val strInstructions: String,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?

)