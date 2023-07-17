package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.features.auth.data.CocktailsRepositoryImpl
import com.example.pet_coctails.fragments.CocktailsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindCocktailsRepositoryImpl(repositoryImpl: CocktailsRepositoryImpl): CocktailsRepository

}