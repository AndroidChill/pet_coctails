package com.example.pet_coctails.features.auth.domain

import com.example.pet_coctails.ApiResponse
import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.activity.main.MainResponse

interface AuthRepository {

    suspend fun main(request: MainRequest): ApiResponse<MainResponse>

}