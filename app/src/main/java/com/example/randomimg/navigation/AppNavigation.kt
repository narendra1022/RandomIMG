package com.example.randomimg.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.randomimg.presentation.GalleryScreen
import com.example.randomimg.presentation.GeneratorScreen
import com.example.randomimg.presentation.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Generator.route) {
            GeneratorScreen(navController)
        }
        composable(Screen.Gallery.route) {
            GalleryScreen(navController)
        }
    }
}
