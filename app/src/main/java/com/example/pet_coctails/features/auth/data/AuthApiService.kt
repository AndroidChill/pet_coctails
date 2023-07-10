package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.ApiResponse
import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.activity.main.MainResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApiService {

    @POST("/main")
    suspend fun main(@Body request: MainRequest): ApiResponse<MainResponse>

    @GET("/all_cocktails")
    suspend fun getListCocktails() : ListCocktailsReponse
}

data class ListCocktailsReponse(
    val data: List<Coctail>
)

data class Coctail(
    val name: String
)