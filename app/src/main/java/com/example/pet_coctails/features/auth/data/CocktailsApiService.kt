package com.example.pet_coctails.features.auth.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET

interface CocktailsApiService {

    @GET("/random.php")
    suspend fun getListCocktails(): ListCocktailsResponse
}

data class ListCocktailsResponse(
    val data: List<Cocktail>
)

@Serializable
data class Cocktail(
    @SerialName("image_link")
    val imageLink: Int,
    val cocktailName: String,
    val id: Int,
    val category: String,
    val cocktailType: String,
    val glassType: String
)