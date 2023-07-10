package com.example.pet_coctails.activity.Onboard

import android.view.LayoutInflater
import com.example.pet_coctails.activity.onboard.OnboardViewModel
import com.example.pet_coctails.core.abstraction.BaseActivity
import com.example.pet_coctails.features.auth.BaseApplication
import com.example.pet_coctails.databinding.ActivityOnboardingBinding
import com.example.pet_coctails.features.auth.di.DaggerAuthComponent

class OnboardActivity : BaseActivity<ActivityOnboardingBinding, OnboardViewModel>() {

    override val getViewBinding: (LayoutInflater) -> ActivityOnboardingBinding
        get() = ActivityOnboardingBinding::inflate

    override val getViewModelClass: Class<OnboardViewModel>
        get() = OnboardViewModel::class.java

    override fun setupDaggerComponent() {
        val authComponent = DaggerAuthComponent
            .builder()
            .coreComponent((application as BaseApplication).getCoreComponent())
            .build()

        authComponent.inject(this)
    }
}