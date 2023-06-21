package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.features.auth.domain.AuthRepository
import dagger.Binds
import dagger.Module
import ru.social.rom_dv.features.auth.data.AuthRepositoryImpl

@Module
interface RepositoryModule {

    @Binds
    fun bindAuthRepositoryImpl(repositoryImpl: AuthRepositoryImpl): AuthRepository

}