package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.ApiResponse
import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.activity.main.MainResponse
import com.example.pet_coctails.features.auth.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authNetworkDataSource: AuthNetworkDataSource,
    private val localDataSource: AuthLocalDataSource
): AuthRepository {

    override suspend fun main(request: MainRequest): ApiResponse<MainResponse> =
        authNetworkDataSource.signIn(request).apply {
            this.data?.let {
                localDataSource.saveToken(it.token)
            }
        }



}