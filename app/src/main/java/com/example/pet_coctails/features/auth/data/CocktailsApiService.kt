package com.example.pet_coctails.features.auth.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CocktailsApiService {

    @GET("search.php?f=a")
    suspend fun getListCocktails(): ListCocktailsResponse
    
    @GET("lookup.php")
    suspend fun get(@Query("i") id: String)
}

data class ListCocktailsResponse(
    val drinks: List<Cocktail>
)

@Serializable
data class Cocktail(
//    val strDrinkThumb: Int,
    val strDrink: String,
    val idDrink: String,
    val strCategory: String,
    val strAlcoholic: String,
    val strGlass: String
)