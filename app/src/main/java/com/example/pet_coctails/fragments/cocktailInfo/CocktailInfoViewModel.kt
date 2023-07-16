package com.example.pet_coctails.fragments.cocktailInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CocktailInfoViewModel @Inject constructor(
    private val cocktailsUseCase: CocktailsUseCase
): ViewModel() {

//todo ТУ ДУ
}