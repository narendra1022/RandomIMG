package com.example.randomimg.presentation.viewmodels

import com.example.randomimg.data.model.Dog

sealed class DogGeneratorState {
    object Initial : DogGeneratorState()
    object Loading : DogGeneratorState()
    data class Success(val dog: Dog) : DogGeneratorState()
    data class Error(val message: String) : DogGeneratorState()
}