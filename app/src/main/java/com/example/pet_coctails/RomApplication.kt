package com.example.pet_coctails

import com.example.pet_coctails.core.scope.CoreComponent
import com.example.pet_coctails.dataBase.DatabaseClient
import com.example.pet_coctails.dataBase.DatabaseClient.Companion
import com.example.pet_coctails.di.component.ApplicationComponent
import com.example.pet_coctails.di.component.DaggerApplicationComponent
import com.example.pet_coctails.di.module.ApplicationModule
import com.example.pet_coctails.features.auth.BaseApplication

/**
 * загрузка изображений с проогрессбаром (готово)
 * onTouchEvent in CocktailRandomFragment - распознать скролл вниз и при удачном скролле показывать BottomSheetFragmentDialog (todo не удается скролл и подгрузка данных в боттом шит)
 * сердечко в списке коктелей (готово)
 * отдельный экран для рандомного коктеля и свайпом получать новый рандомный коктейль (todo осталось разобраться как делать слушатель свайпа)
 * coroutineexcHandler (готово)
 * посмотреть на room
 * */

class RomApplication : BaseApplication() {

//    private lateinit var applicationComponent: ApplicationComponent
    lateinit var databaseClient: DatabaseClient
    
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }
    
    var timeClosed = 0L
    
    override fun onCreate() {
        super.onCreate()
        injectDependencies()

        databaseClient = DatabaseClient.getInstance(applicationContext)

    }
    
    fun getDataBase() = databaseClient.appDatabase
    
    private fun isWorkSleptActivity(): Boolean {
        return timeClosed == 0L || (System.currentTimeMillis() - timeClosed > 30_000)
    }
    
    override fun getCoreComponent(): CoreComponent {
        return appComponent.baseComponent().create()
    }
    
    private fun injectDependencies() {
        appComponent.inject(this)
    }
    
}