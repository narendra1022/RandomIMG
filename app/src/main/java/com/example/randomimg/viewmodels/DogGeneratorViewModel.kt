package com.example.randomimg.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomimg.data.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogGeneratorViewModel @Inject constructor(
    private val repository: DogRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<DogGeneratorState>(DogGeneratorState.Initial)
    val uiState: StateFlow<DogGeneratorState> = _uiState.asStateFlow()

    fun generateDog() {
        viewModelScope.launch {
            _uiState.value = DogGeneratorState.Loading
            repository.getRandomDog()
                .onSuccess { dog ->
                    _uiState.value = DogGeneratorState.Success(dog)
                }
                .onFailure { error ->
                    _uiState.value = DogGeneratorState.Error(error.message ?: "Unknown error")
                }
        }
    }
}