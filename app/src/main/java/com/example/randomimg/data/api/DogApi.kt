package com.example.randomimg.data.api

import retrofit2.http.GET

interface DogApi {
    @GET("breeds/image/random")
    suspend fun getRandomDog(): DogResponse
}