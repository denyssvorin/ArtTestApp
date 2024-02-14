package com.example.arttestapp.ui

sealed class ScreenNavigation(val route: String) {
    data object FirstScreen: ScreenNavigation("first_screen")
    data object SecondScreen: ScreenNavigation("second_screen")
    data object ThirdScreen: ScreenNavigation("third_screen")
}