package com.example.day2

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Login : Screen("login")
    object Signup : Screen("signup")
}

