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
//    private val cocktailsUseCase: CocktailsUSeCase
): ViewModel(){
//
//    val state = MutableSharedFlow<ListCocktailsResponse>()
//
//    suspend fun getAllCocktails() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = cocktailsUseCase.getAll()
//            state.emit(response)
//        }
//    }
}