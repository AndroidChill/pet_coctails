package com.example.pet_coctails.features.auth.domain

import com.example.pet_coctails.ApiResponse
import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.activity.main.MainResponse
import com.example.pet_coctails.core.scope.FeatureScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@FeatureScope
class AuthUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend fun signIn(login: String, password: String): Flow<ApiResponse<MainResponse>> = flow {
        emit(repository.main(MainRequest(name = String(), id = String(), category = String(), cocktailType = String(), glassType = String())))
    }

}