package com.example.randomimg.data.cache

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.randomimg.data.PreferencesKeys
import com.example.randomimg.data.api.Dog
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class DogCache @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private val dogListFlow = MutableStateFlow<List<Dog>>(emptyList())
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    init {
        scope.launch {
            loadCachedDogs()
        }
    }

    private suspend fun loadCachedDogs() {
        dataStore.data.first().let { preferences ->
            val dogsJson = preferences[PreferencesKeys.CACHED_DOGS] ?: "[]"
            val dogs = Gson().fromJson<List<Dog>>(dogsJson, object : TypeToken<List<Dog>>() {}.type)
            dogListFlow.value = dogs.takeLast(20)
        }
    }

    suspend fun addDog(dog: Dog) {
        val currentDogs = dogListFlow.value.toMutableList()
        currentDogs.add(dog)
        if (currentDogs.size > 20) {
            dogListFlow.value = currentDogs.subList(1, currentDogs.size)
        } else {
            dogListFlow.value = currentDogs
        }
        saveCachedDogs()
    }

    private suspend fun saveCachedDogs() {
        val dogsJson = Gson().toJson(dogListFlow.value)
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.CACHED_DOGS] = dogsJson
        }
    }

    suspend fun clearCache() {
        dogListFlow.value = emptyList()
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    fun getCachedDogs(): Flow<List<Dog>> = dogListFlow.map { dogs ->
        dogs.reversed()
    }
}
