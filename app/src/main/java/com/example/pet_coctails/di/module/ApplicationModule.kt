package com.example.pet_coctails.di.module

import android.content.Context
import com.example.pet_coctails.RomApplication
import com.example.pet_coctails.features.auth.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: RomApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application.applicationContext
    }




//    @BaseUrl
//    @Provides
//    fun provideBaseUrl(): String = "https://rom-dv-api.herokuapp.com/"
//
//    @Provides
//    @Singleton
//    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()
//
//    @Provides
//    @Singleton
//    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        return loggingInterceptor
//    }
//
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
//        val client = OkHttpClient.Builder()
//        if (BuildConfig.DEBUG) {
//            client.addInterceptor(loggingInterceptor)
//        }
//        return client.build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory,@BaseUrl baseUrl: String): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(gsonConverterFactory)
//            .client(okHttpClient)
//            .build()
//    }

}