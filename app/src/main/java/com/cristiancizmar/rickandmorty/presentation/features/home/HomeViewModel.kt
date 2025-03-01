package com.cristiancizmar.rickandmorty.presentation.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiancizmar.rickandmorty.domain.Character
import com.cristiancizmar.rickandmorty.data.CharactersRepository
import com.cristiancizmar.rickandmorty.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CharactersRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    sealed class HomeEvent {
        data object LoadCharacters : HomeEvent()
    }

    var state by mutableStateOf<State<List<Character>>>(State.Loading)
        private set

    init {
        loadCharacters()
    }

    fun onAction(homeEvent: HomeEvent) {
        when (homeEvent) {
            HomeEvent.LoadCharacters -> {
                loadCharacters()
            }
        }
    }

    private fun loadCharacters() {
        state = State.Loading
        viewModelScope.launch(dispatcher) {
            try {
                val response = repository.getCharacters()
                state = State.Success(response.results)
            } catch (e: Exception) {
                state = State.Error(e)
            }
        }
    }
}