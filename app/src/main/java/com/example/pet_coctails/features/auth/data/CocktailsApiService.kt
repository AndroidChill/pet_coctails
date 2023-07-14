package com.example.pet_coctails.features.auth.data

import retrofit2.http.GET

interface CocktailsApiService {

    @GET("/random.php")
    suspend fun getListCocktails(): ListCocktailsResponse

    data class ListCocktailsResponse(
        val data: List<Cocktail>
    )

    data class Cocktail(
        val imageLink: Int,
        val cocktailName: String,
        val id: Int,
        val category: String,
        val cocktailType: String,
        val glassType: String
    )
}