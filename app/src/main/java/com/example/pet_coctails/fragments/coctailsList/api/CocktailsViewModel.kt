package com.example.pet_coctails.fragments.coctailsList.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pet_coctails.MetaData
import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.activity.main.MainResponse
import com.example.pet_coctails.core.scope.FeatureScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@FeatureScope
class CocktailsViewModel @Inject constructor(
    private val useCase: CocktailsUseCase
): ViewModel() {

    val result = MutableSharedFlow<MainResponse>()

    val error = MutableSharedFlow<MetaData>()

    suspend fun main (request: MainRequest) {
        viewModelScope.launch (Dispatchers.IO){

        }
    }
}