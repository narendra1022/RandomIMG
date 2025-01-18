package com.example.randomimg.viewmodels

import com.example.randomimg.data.api.Dog

sealed class DogGeneratorState {
    object Initial : DogGeneratorState()
    object Loading : DogGeneratorState()
    data class Success(val dog: Dog) : DogGeneratorState()
    data class Error(val message: String) : DogGeneratorState()
}