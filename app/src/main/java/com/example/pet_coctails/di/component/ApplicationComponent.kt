package com.example.pet_coctails.di.component

import android.app.Application
import com.example.pet_coctails.core.scope.CoreComponent
import com.example.pet_coctails.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent {

    fun inject(application: Application)
    fun baseComponent(): CoreComponent.Factory
}