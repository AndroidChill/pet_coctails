package com.example.pet_coctails.features.auth.di

import com.example.pet_coctails.activity.onboard.OnboardActivity
import com.example.pet_coctails.activity.main.MainActivity
import com.example.pet_coctails.core.scope.CoreComponent
import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.fragments.coctailsList.CocktailsListFragment
import com.example.pet_coctails.fragments.OnboardFirstFragment
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
//        NetworkModule::class,
        NetworkModule::class,
        NetworkCocktailsModule::class,
        DataModule::class,
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