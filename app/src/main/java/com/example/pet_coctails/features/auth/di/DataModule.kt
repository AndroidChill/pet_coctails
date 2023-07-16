package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.core.scope.FeatureScope
import dagger.Module
import dagger.Provides
import com.example.pet_coctails.features.auth.data.CocktailsNetworkDataSource
import com.example.pet_coctails.features.auth.data.CocktailsApiService
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsRepository
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsUseCase

@Module
object DataModule {

    @Provides
    @FeatureScope
    fun provideCocktailsNetworkDataSource(cocktailsApiService: CocktailsApiService): CocktailsNetworkDataSource =
        CocktailsNetworkDataSource(cocktailsApiService)


    @Provides
    @FeatureScope
    fun provideCocktailsUseCase(cocktailsRepository: CocktailsRepository): CocktailsUseCase =
        CocktailsUseCase(cocktailsRepository)
}