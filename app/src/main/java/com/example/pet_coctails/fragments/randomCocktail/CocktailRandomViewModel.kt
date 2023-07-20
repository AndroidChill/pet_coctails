package com.example.pet_coctails.fragments.randomCocktail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pet_coctails.features.auth.data.CocktailFullInfo
import com.example.pet_coctails.fragments.CocktailSum
import com.example.pet_coctails.fragments.CocktailsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class CocktailRandomViewModel @Inject constructor(
    private val cocktailsUseCase: CocktailsUseCase
): ViewModel() {


    private var _state = MutableStateFlow<CocktailRandomState>(CocktailRandomState())
    val state = _state.asStateFlow()

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        _state.update { oldState ->
            oldState.copy(
                events = oldState.events + CocktailRandomState.Event.ShowError
            )
            
        }
    }
    
    suspend fun getRandomCocktailInfo(){
        viewModelScope.launch(coroutineExceptionHandler + CoroutineName("getFullCocktail")) {
            val response = cocktailsUseCase.cocktailRandom()
            _state.update { oldState ->
                oldState.copy(
                    events = oldState.events + CocktailRandomState.Event.LoadFullCocktailInfo(
                        response
                    )
                )

            }
        }
        
    }
}

data class CocktailRandomState(

    val events: List<Event> = emptyList()

) {

    sealed class Event {

        class LoadFullCocktailInfo (val data: CocktailSum) : Event()

        object ShowError : Event()
    }



}