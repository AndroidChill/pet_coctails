package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.dataBase.CocktailsDao
import dagger.Module
import dagger.Provides
import com.example.pet_coctails.features.auth.data.CocktailsNetworkDataSource
import com.example.pet_coctails.features.auth.data.CocktailsApiService
import com.example.pet_coctails.features.auth.data.CocktailsLocalDataSource
import com.example.pet_coctails.fragments.CocktailsRepository
import com.example.pet_coctails.fragments.CocktailsUseCase

@Module
object DataModule {

    @Provides
    @FeatureScope
    fun provideCocktailsNetworkDataSource(cocktailsApiService: CocktailsApiService): CocktailsNetworkDataSource =
        CocktailsNetworkDataSource(cocktailsApiService)
    
//    @Provides
//    @FeatureScope
//    fun provideCocktailsNetworkDataSource(dao: CocktailsDao): CocktailsLocalDataSource =
//        CocktailsLocalDataSource(dao)


    @Provides
    @FeatureScope
    fun provideCocktailsUseCase(cocktailsRepository: CocktailsRepository): CocktailsUseCase =
        CocktailsUseCase(cocktailsRepository)
}