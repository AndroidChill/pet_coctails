package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.activity.onboard.OnboardActivity
import com.example.pet_coctails.activity.main.MainActivity
import com.example.pet_coctails.core.scope.CoreComponent
import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.fragments.CocktailsListFragment
import com.example.pet_coctails.fragments.OnboardFirstFragment
import dagger.Component
import ru.social.rom_dv.features.auth.di.AuthViewModelModule

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        AuthViewModelModule::class
    ]
)
interface AuthComponent {

    fun inject(activity: OnboardActivity)
    fun inject(activity: MainActivity)
    fun inject(fragment: OnboardFirstFragment)
    fun inject(activity: CocktailsListFragment)


}