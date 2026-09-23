package com.ronda.tecsup_fit.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ronda.tecsup_fit.navigation.Screen

@Composable
fun DetailScreen(
    navController: NavController,
    itemId: Int
) {
    val clase = clases.find { it.id == itemId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "← Detalle de clase",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.clickable { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = clase?.nombre ?: "Clase",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("${clase?.hora ?: ""} • ${clase?.sala ?: ""}")

        Spacer(modifier = Modifier.height(20.dp))

        Text("Entrenamiento funcional de alta intensidad.")

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.navigate(Screen.Confirmation.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reservar cupo")
        }
    }
}
