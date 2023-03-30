package com.example.day2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.day2.ui.theme.Day2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Signup.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(
            Screen.Login.route + "/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { navBackStackEntry -> LoginScreen(navController,navBackStackEntry.arguments?.getString("name")!!)  }
        composable(Screen.Signup.route) { SignupScreen(navController) }
    }
}

