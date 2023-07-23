package com.example.pet_coctails.fragments.cocktailsList.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pet_coctails.core.scope.FeatureScope
import com.example.pet_coctails.dataBase.CocktailsDataEntity
import com.example.pet_coctails.dataBase.CocktailsDataRepository
import com.example.pet_coctails.dataBase.CocktailsIdData
import com.example.pet_coctails.features.auth.data.Cocktail
import com.example.pet_coctails.features.auth.data.CocktailFullInfo
import com.example.pet_coctails.features.auth.data.CocktailResponse
import com.example.pet_coctails.fragments.CocktailsRepository
import com.example.pet_coctails.fragments.CocktailsUseCase
import com.example.pet_coctails.fragments.cocktailInfo.CocktailInfoState
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState.Action.OnClickCocktail
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState.Action.OnClickFavourite
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
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

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        _state.update { oldState ->
            oldState.copy(
                events = oldState.events + CocktailsState.Event.ShowError
            )

        }
    }
    
    init {
        viewModelScope.launch {
            getAllCocktails()
        }

    }
    
    fun handleAction(action: CocktailsState.Action) {
        
        when (action) {
            is OnClickCocktail -> {
                _state.update { oldState ->
                    oldState.copy(
                        events = oldState.events + CocktailsState.Event.MoveToCocktailInfo(
                            action.id
                        )
                    )
                }
            }
            
            is OnClickFavourite -> {
                val newCocktail = CocktailsIdData (idCocktail = action.id)
//                cocktailsUseCase.insertNewCocktailData(CocktailsDataEntity(idCocktail = action.id))
//                CocktailsDataRepository().insertNewCocktailData(newCocktail.toCocktailsDataEntity()) //todo
            }
        }
    }
    
    // For CocktailsListFragment
    suspend fun getAllCocktails() {
        viewModelScope.launch (coroutineExceptionHandler + CoroutineName("getAllCocktails")) {
            
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
        object ShowError : Event()
        class MoveToCocktailInfo(val idDrink: String) : Event()
    }
    
    sealed class Action {
        class OnClickCocktail(val id: String) : Action()
        
        class OnClickFavourite(val id: String) : Action()
    }

    
}