package ru.social.rom_dv.features.auth.data

import com.example.pet_coctails.features.auth.UserStore
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(
    private val userStore: UserStore
) {

    suspend fun saveToken(token: String) {
        userStore.saveToken(token)
    }

}