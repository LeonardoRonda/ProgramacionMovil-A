package com.ronda.tecsup_fit.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RoutinesScreen(
    @Suppress("UNUSED_PARAMETER") navController: NavController,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {

        Text(
            "Rutinas",
            style = MaterialTheme.typography.headlineMedium,
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text("🏋 Yoga funcional")

        Spacer(modifier = Modifier.height(15.dp))

        Text("💪 Cross Training")

        Spacer(modifier = Modifier.height(15.dp))

        Text("🏃 Spinning")
    }
}
