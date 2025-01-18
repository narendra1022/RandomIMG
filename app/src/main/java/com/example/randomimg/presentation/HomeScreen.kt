package com.example.randomimg.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.randomimg.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Random Dog Generator!",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(68.dp))

        NavigationButton(
            text = "Generate Dogs",
            onClick = { navController.navigate(Screen.Generator.route) }
        )

        Spacer(modifier = Modifier.height(24.dp))

        NavigationButton(
            text = "My Recently Generated Dogs",
            onClick = { navController.navigate(Screen.Gallery.route) }
        )
    }

}