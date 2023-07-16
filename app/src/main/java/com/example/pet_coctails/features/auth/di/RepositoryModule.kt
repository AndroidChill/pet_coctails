package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.features.auth.data.CocktailsRepositoryImpl
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindAuthRepositoryImpl(repositoryImpl: CocktailsRepositoryImpl): CocktailsRepository

}