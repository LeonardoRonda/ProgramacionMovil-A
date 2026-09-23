package com.ronda.tecsup_fit.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ronda.tecsup_fit.screen.ConfirmationScreen
import com.ronda.tecsup_fit.screen.DetailScreen
import com.ronda.tecsup_fit.screen.HomeScreen
import com.ronda.tecsup_fit.screen.ProfileScreen
import com.ronda.tecsup_fit.screen.ReservationsScreen
import com.ronda.tecsup_fit.screen.RoutinesScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomBarRoutes = listOf(
        Screen.Home.route,
        Screen.Reservations.route,
        Screen.Routines.route,
        Screen.Profile.route,
    )

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomBarRoutes) {
                NavigationBar {
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                        label = { Text("Inicio") },
                        selected = currentRoute == Screen.Home.route,
                        onClick = {
                            navController.navigate(Screen.Home.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.DateRange, contentDescription = "Reservas") },
                        label = { Text("Reservas") },
                        selected = currentRoute == Screen.Reservations.route,
                        onClick = {
                            navController.navigate(Screen.Reservations.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Rutinas") },
                        label = { Text("Rutinas") },
                        selected = currentRoute == Screen.Routines.route,
                        onClick = {
                            navController.navigate(Screen.Routines.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                        label = { Text("Perfil") },
                        selected = currentRoute == Screen.Profile.route,
                        onClick = {
                            navController.navigate(Screen.Profile.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding),
        ) {

            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(
                route = Screen.Detail.route,
                arguments = listOf(
                    navArgument("itemId") {
                        type = NavType.IntType
                    },
                ),
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
}
