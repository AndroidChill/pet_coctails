package com.example.pet_coctails.activity.main

import android.view.LayoutInflater
import com.example.pet_coctails.R
import com.example.pet_coctails.core.abstraction.BaseActivity
import com.example.pet_coctails.databinding.ActivityMainBinding
import com.example.pet_coctails.features.auth.BaseApplication
import com.example.pet_coctails.features.auth.di.DaggerAuthComponent
import com.example.pet_coctails.fragments.overs.MainFragment

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val getViewBinding: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override val getViewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun setupDaggerComponent() {
        val authComponent = DaggerAuthComponent
            .builder()
            .coreComponent((application as BaseApplication).getCoreComponent())
            .build()

        authComponent.inject(this)
    }

    override fun initUI() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()

    }

}