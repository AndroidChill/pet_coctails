package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.features.auth.domain.AuthRepository
import com.example.pet_coctails.features.auth.data.AuthApiService
import com.example.pet_coctails.features.auth.domain.AuthUseCase
import dagger.Module
import dagger.Provides
import com.example.pet_coctails.features.auth.data.AuthNetworkDataSource
import com.example.pet_coctails.features.auth.data.CocktailsNetworkDataSource
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsApiService
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsRepository
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsUseCase

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

    @Provides
    @FeatureScope
    fun provideCocktailsNetworkDataSource(cocktailsApiService: CocktailsApiService): CocktailsNetworkDataSource =
        CocktailsNetworkDataSource(cocktailsApiService)


    @Provides
    @FeatureScope
    fun provideCocktailsUseCase(cocktailsRepository: CocktailsRepository): CocktailsUseCase =
        CocktailsUseCase(cocktailsRepository)
}
