package com.example.pet_coctails.features.auth

import android.app.Application
import com.example.pet_coctails.core.scope.CoreComponent

abstract class BaseApplication : Application() {

    abstract fun getCoreComponent(): CoreComponent

}