package com.example.pet_coctails.features.auth.di

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        Log.i("test", "test")
    }

}