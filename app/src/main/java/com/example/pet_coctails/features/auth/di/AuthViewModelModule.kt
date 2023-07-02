package com.example.pet_coctails.features.auth.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pet_coctails.activity.onboard.OnboardViewModel
import com.example.pet_coctails.activity.main.MainViewModel
import com.example.pet_coctails.core.annotation.ViewModelKey
import com.example.pet_coctails.core.factory.ViewModelFactory
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


    companion object {
        @Provides
        @JvmStatic
        internal fun provideViewModelFactory(viewModelMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory {
            return ViewModelFactory(viewModelMap)
        }
    }

}