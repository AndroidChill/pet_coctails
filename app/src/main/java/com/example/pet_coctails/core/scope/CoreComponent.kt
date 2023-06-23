package com.example.pet_coctails.core.scope

import com.example.pet_coctails.features.auth.UserStore
import dagger.Subcomponent
import retrofit2.Retrofit

@Subcomponent
interface CoreComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CoreComponent
    }

    fun userStore(): UserStore

}