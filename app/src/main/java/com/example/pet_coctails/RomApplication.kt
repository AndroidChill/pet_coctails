package com.example.pet_coctails

import com.example.pet_coctails.core.scope.CoreComponent
import com.example.pet_coctails.di.component.ApplicationComponent
import com.example.pet_coctails.di.component.DaggerApplicationComponent
import com.example.pet_coctails.di.module.ApplicationModule
import com.example.pet_coctails.features.auth.BaseApplication

/**
 * загрузка изображений с проогрессбаром
 * onTouchEvent in CocktailInfoFragment - распознать скролл вниз и при удачном скролле показывать BottomSheetFragmentDialog
 * сердечко в списке коктелей
 * отдельный экран для рандомного коктеля и свайпом получать новый рандомный коктейль
 * coroutineexcHandler
 * посмотреть на room
 * */

class RomApplication : BaseApplication() {

//    private lateinit var applicationComponent: ApplicationComponent
    
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }
    
    var timeClosed = 0L
    
    override fun onCreate() {
        super.onCreate()
        injectDependencies()

//        registerActivityLifecycleCallbacks(object: ActivityLifecycleCallbacks {
//
//            override fun onActivityPreStarted(activity: Activity) {
//                super.onActivityPreStarted(activity)
//                if (activity is MainActivity && isWorkSleptActivity()){
//                    val intent = Intent (activity, OnboardActivity::class.java)
//                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    startActivity(intent)
//                }
//            }
//
//            override fun onActivityCreated(p0: Activity, p1: Bundle?) {}
//
//            override fun onActivityStarted(p0: Activity) {}
//
//            override fun onActivityResumed(p0: Activity) {}
//
//            override fun onActivityPaused(p0: Activity) {}
//
//            override fun onActivityStopped(p0: Activity) {
//                timeClosed = System.currentTimeMillis()
//            }
//
//            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}
//
//            override fun onActivityDestroyed(p0: Activity) {}
//        })
    }
    
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