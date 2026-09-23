package com.ronda.tecsup_fit.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ronda.tecsup_fit.navigation.Screen

@Composable
fun ConfirmationScreen(
    navController: NavController,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            "✓",
            style = MaterialTheme.typography.displayMedium,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "¡Cupo reservado!",
            style = MaterialTheme.typography.headlineSmall
        )

        Text("Cross Training")
        Text("Hoy, 6:00 pm • Sala 1")

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate(Screen.Reservations.route)
            }
        ) {
            Text("Ver mis reservas")
        }
    }
}