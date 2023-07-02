package com.example.pet_coctails.features.auth.data

import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.features.auth.data.AuthApiService
import javax.inject.Inject

@FeatureScope
class AuthNetworkDataSource @Inject constructor(
    private val authApiService: AuthApiService
) {

    suspend fun signIn(request: MainRequest) = authApiService.main(request)

}