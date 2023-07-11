package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.features.auth.domain.AuthRepository
import com.example.pet_coctails.features.auth.data.AuthApiService
import com.example.pet_coctails.features.auth.domain.AuthUseCase
import dagger.Module
import dagger.Provides
import com.example.pet_coctails.features.auth.data.AuthNetworkDataSource

@Module
object DataModule {

    @Provides
    @FeatureScope
    fun provideAuthNetworkDataSource(authApiService: AuthApiService): AuthNetworkDataSource =
        AuthNetworkDataSource(authApiService)


    @Provides
    @FeatureScope
    fun provideAuthUseCase(authRepository: AuthRepository): AuthUseCase =
        AuthUseCase(authRepository)
}
