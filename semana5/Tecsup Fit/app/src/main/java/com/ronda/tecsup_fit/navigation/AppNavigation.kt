package com.ronda.tecsup_fit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ronda.tecsup_fit.screen.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val itemId =
                backStackEntry.arguments?.getInt("itemId") ?: 0

            DetailScreen(navController, itemId)
        }

        composable(Screen.Confirmation.route) {
            ConfirmationScreen(navController)
        }

        composable(Screen.Reservations.route) {
            ReservationsScreen(navController)
        }

        composable(Screen.Routines.route) {
            RoutinesScreen(navController)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}