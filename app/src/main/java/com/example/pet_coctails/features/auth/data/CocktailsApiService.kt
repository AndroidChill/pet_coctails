package com.example.pet_coctails.features.auth.data

import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsApiService {

    @GET("search.php?f=a")
    suspend fun getListCocktails(): ListCocktailsResponse

    @GET("lookup.php")
    suspend fun getInfo(@Query("i") id: String): CocktailResponse
}

data class ListCocktailsResponse(
    val drinks: List<Cocktail>
)

@Serializable
data class Cocktail(
//    val strDrinkThumb: String,
    val strDrink: String,
    val idDrink: String,
    val strCategory: String,
    val strAlcoholic: String,
    val strGlass: String
)

data class CocktailResponse (
    val cocktailFullInfo: List <CocktailFullInfo>
        )

@Serializable
data class CocktailFullInfo(
//    val strDrinkThumb: String,
    val strDrink: String,
    val idDrink: String,
    val strCategory: String,
    val strAlcoholic: String,
    val strGlass: String,
    val strInstructions: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strIngredient6: String,
    val strIngredient7: String,
    val strIngredient8: String,
    val strIngredient9: String,
    val strIngredient10: String,
    val strIngredient11: String,
    val strIngredient12: String,
    val strIngredient13: String,
    val strIngredient14: String,
    val strIngredient15: String,
    val strMeasure1: String,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String,
    val strMeasure5: String,
    val strMeasure6: String,
    val strMeasure7: String,
    val strMeasure8: String,
    val strMeasure9: String,
    val strMeasure10: String,
    val strMeasure11: String,
    val strMeasure12: String,
    val strMeasure13: String,
    val strMeasure14: String,
    val strMeasure15: String

)