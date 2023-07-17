package com.example.pet_coctails.fragments.cocktailInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pet_coctails.features.auth.data.Cocktail
import com.example.pet_coctails.features.auth.data.CocktailFullInfo
import com.example.pet_coctails.fragments.CocktailsUseCase
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class CocktailInfoViewModel @Inject constructor(
    private val cocktailsUseCase: CocktailsUseCase
): ViewModel() {

//todo ТУ ДУ

    private var _state = MutableStateFlow<CocktailInfoState>(CocktailInfoState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch{
            getFullCocktailInfo()
        }
    }
    suspend fun getFullCocktailInfo(){
        viewModelScope.launch {
            val response = cocktailsUseCase.cocktailInfo()
            _state.update { oldState ->
                oldState.copy(
                    events = oldState.events + CocktailInfoState.Event.LoadFullCocktailInfo(
                        response.cocktailFullInfo
                    )
                )

            }
        }
    }
}

data class CocktailInfoState(

    val events: List<Event> = emptyList()

) {

    sealed class Event {
        class LoadFullCocktailInfo(val data: List<CocktailFullInfo>) : Event()

    }



}