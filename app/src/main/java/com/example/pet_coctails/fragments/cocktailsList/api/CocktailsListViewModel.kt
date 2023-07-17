package com.example.pet_coctails.fragments.cocktailsList.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.features.auth.data.Cocktail
import com.example.pet_coctails.features.auth.data.CocktailResponse
import com.example.pet_coctails.fragments.CocktailsRepository
import com.example.pet_coctails.fragments.CocktailsUseCase
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState.Action.OnClickCocktail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
                viewModelScope.launch {
                    val cocktail = cocktailsUseCase.cocktailInfo()
                    _state.update { oldState ->
                        oldState.copy(
                            events = oldState.events + CocktailsState.Event.MoveToCocktailInfo(
                                responseIntoCocktail(cocktailsUseCase.cocktailInfo())
                            )
                        )
                    }

                }
            }
        }
    }

    fun responseIntoCocktail(into: CocktailResponse) : Cocktail{

        val list = into.cocktailFullInfo.slice(0..4)

        return Cocktail(
            list[0].toString(),
            list[1].toString(),
            list[2].toString(),
            list[3].toString(),
            list[4].toString(),
        )
    }

    // For CocktailsListFragment
    suspend fun getAllCocktails() {
        viewModelScope.launch {

            val response = cocktailsUseCase.cocktailsList()
            _state.update { oldState ->
                oldState.copy(
                    events = oldState.events + CocktailsState.Event.LoadAllCocktails(
                        response.drinks
                    )
                )
            }
        }

    }
}

data class CocktailsState(
    val events: List<Event> = emptyList()
) {

    sealed class Event {
        class LoadAllCocktails(val data: List<Cocktail>) : Event()

        class MoveToCocktailInfo(val data: Cocktail) : Event()
    }

    sealed class Action {
        class OnClickCocktail(val id: String) : Action()
    }


}