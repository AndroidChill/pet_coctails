package com.example.pet_coctails.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.pet_coctails.features.auth.data.ListCocktailsReponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
//    private val coctailsUseCase: CoctailsUSeCase
): ViewModel(){
//
//    val state = MutableSharedFlow<ListCocktailsReponse>()
//
//    suspend fun getAllCoctails() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = coctailsUseCase.getAll()
//            state.emit(response)
//        }
//    }
}