package com.example.pet_coctails.features.auth.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pet_coctails.activity.onboard.OnboardViewModel
import com.example.pet_coctails.activity.main.MainViewModel
import com.example.pet_coctails.core.annotation.ViewModelKey
import com.example.pet_coctails.core.factory.ViewModelFactory
import com.example.pet_coctails.fragments.cocktailInfo.CocktailInfoViewModel
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsViewModel
import com.example.pet_coctails.fragments.randomCocktail.CocktailRandomViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
abstract class AuthViewModelModule {

//    fun provideViewModelFactory() = ViewModelFactory()

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OnboardViewModel::class)
    internal abstract fun provideOnboardViewModel(viewModel: OnboardViewModel): ViewModel
    
    @Binds
    @IntoMap
    @ViewModelKey(CocktailsViewModel::class)
    internal abstract fun provideCocktailsViewModel(viewModel: CocktailsViewModel): ViewModel
    
    @Binds
    @IntoMap
    @ViewModelKey(CocktailInfoViewModel::class)
    internal abstract fun provideCocktailInfoViewModel(viewModel: CocktailInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CocktailRandomViewModel::class)
    internal abstract fun provideCocktailRandomViewModel(viewModel: CocktailRandomViewModel): ViewModel
    
    
    companion object {
        @Provides
        @JvmStatic
        internal fun provideViewModelFactory(viewModelMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory {
            return ViewModelFactory(viewModelMap)
        }
    }

}