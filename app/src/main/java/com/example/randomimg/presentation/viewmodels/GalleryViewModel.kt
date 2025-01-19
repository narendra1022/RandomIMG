package com.example.randomimg.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomimg.data.model.Dog
import com.example.randomimg.data.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: DogRepository
) : ViewModel() {
    val dogs: StateFlow<List<Dog>> = repository.getCachedDogs()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun clearGallery() {
        viewModelScope.launch {
            repository.clearCache()
        }
    }
}