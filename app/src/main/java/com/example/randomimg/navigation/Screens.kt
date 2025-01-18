package com.example.randomimg.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Generator : Screen("generator")
    object Gallery : Screen("gallery")
}