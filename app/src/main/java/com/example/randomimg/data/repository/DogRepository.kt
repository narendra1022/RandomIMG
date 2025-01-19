package com.example.randomimg.data.repository

import com.example.randomimg.data.model.Dog
import com.example.randomimg.data.api.DogApi
import com.example.randomimg.data.cache.DogCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val api: DogApi,
    private val cache: DogCache
) {
    suspend fun getRandomDog(): Result<Dog> = try {
        val response = api.getRandomDog()
        if (response.status == "success") {
            val dog = Dog(imageUrl = response.imageUrl)
            cache.addDog(dog)
            Result.success(dog)
        } else {
            Result.failure(Exception("Failed to fetch dog"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    fun getCachedDogs(): Flow<List<Dog>> = cache.getCachedDogs()

    suspend fun clearCache() = cache.clearCache()
}