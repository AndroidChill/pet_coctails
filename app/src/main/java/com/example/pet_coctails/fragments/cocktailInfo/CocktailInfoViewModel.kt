package com.example.pet_coctails.fragments.cocktailInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pet_coctails.fragments.CocktailSum
import com.example.pet_coctails.fragments.CocktailsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class CocktailInfoViewModel @Inject constructor(
    private val cocktailsUseCase: CocktailsUseCase
): ViewModel() {


    private var _state = MutableStateFlow<CocktailInfoState>(CocktailInfoState())
    val state = _state.asStateFlow()

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        _state.update { oldState ->
            oldState.copy(
                events = oldState.events + CocktailInfoState.Event.ShowError
            )
            
        }
    }
    
    suspend fun getFullCocktailInfo(id: String){
        viewModelScope.launch(coroutineExceptionHandler + CoroutineName("getFullCocktail")) {
            val response = cocktailsUseCase.cocktailInfo(id)
            _state.update { oldState ->
                oldState.copy(
                    cocktail = response,
                    events = oldState.events + CocktailInfoState.Event.LoadFullCocktailInfo(
                        response
                    )
                )
            }
        }
        
    }
}

data class CocktailInfoState(
    val cocktail: CocktailSum = CocktailSum(),
    val events: List<Event> = emptyList()
) {

    sealed class Event {
        class LoadFullCocktailInfo(val data: CocktailSum) : Event()

        object ShowError : Event()
    }



}