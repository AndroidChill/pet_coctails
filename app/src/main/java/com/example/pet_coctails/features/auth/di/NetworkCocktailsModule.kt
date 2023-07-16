package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.features.auth.data.CocktailsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object NetworkCocktailsModule {
    @Provides
    @FeatureScope
    fun provideCocktailsApiService(retrofit: Retrofit): CocktailsApiService = retrofit.create(
        CocktailsApiService::class.java)
}