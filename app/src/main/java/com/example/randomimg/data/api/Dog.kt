package com.example.randomimg.data.api

import java.util.UUID

data class Dog(
    val id: String = UUID.randomUUID().toString(),
    val imageUrl: String,
    val timestamp: Long = System.currentTimeMillis()
)