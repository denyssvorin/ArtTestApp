package com.example.arttestapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arttestapp.ui.screen1.FirstScreen
import com.example.arttestapp.ui.screen2.SecondScreen
import com.example.arttestapp.ui.screen3.ThirdScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenNavigation.FirstScreen.route
    ) {
        composable(route = ScreenNavigation.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(route = ScreenNavigation.SecondScreen.route) {
            SecondScreen(navController = navController)
        }
        composable(route = ScreenNavigation.ThirdScreen.route
        ) {
            ThirdScreen(navController = navController)
        }
    }
}