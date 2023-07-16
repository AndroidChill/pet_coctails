package com.example.pet_coctails.fragments.coctailsList.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pet_coctails.MetaData
import com.example.pet_coctails.activity.main.MainRequest
import com.example.pet_coctails.activity.main.MainResponse
import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.features.auth.data.Cocktail
import com.example.pet_coctails.features.auth.domain.model.CocktailsListResponse
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsState.Action.OnClickCocktail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@FeatureScope
class CocktailsViewModel @Inject constructor(
    private val cocktailsUseCase: CocktailsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<CocktailsState>(CocktailsState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getAllCocktails()
        }
    }

    fun handleAction(action: CocktailsState.Action) {
        when (action) {
            is OnClickCocktail -> {
                // val cocktail = coctailUseCase.getInFoCoctailById()
                // moveToCoctailInfo()
                /**
                 *  _state.update { oldState ->
                 *                 oldState.copy(
                 *                     events = oldState.events + CocktailsState.Event.MoveToCocktailINfo(
                 *                         cocktail
                 *                     )
                 *                 )
                 *             }
                 * */
                
            }
        }
    }

    suspend fun getAllCocktails() {
//        viewModelScope.launch {
        try {
            val response = cocktailsUseCase.cocktailsList()
            _state.update { oldState ->
                oldState.copy(
                    events = oldState.events + CocktailsState.Event.LoadAllCocktails(
                        response.drinks
                    )
                )
            }
        } catch (e: Exception) {
            val k = 4
        }
        
    }
}

data class CocktailsState(
    val events: List<Event> = emptyList()
) {

    sealed class Event {
        class LoadAllCocktails(val data: List<Cocktail>) : Event()
        
        class MoveToCocktailINfo(val data: Cocktail) : Event()
    }

    sealed class Action { class OnClickCocktail(val id: String) : Action()
    }

}