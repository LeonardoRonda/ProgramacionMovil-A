package com.ronda.tecsup_fit.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ReservationsScreen(
    @Suppress("UNUSED_PARAMETER") navController: NavController,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        Text(
            "Mis reservas",
            style = MaterialTheme.typography.headlineMedium,
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(clases.take(2)) { clase ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp),
                    ) {

                        Text(
                            clase.nombre,
                            style = MaterialTheme.typography.titleMedium,
                        )

                        Text("${clase.hora} • ${clase.sala}")

                        Text("Confirmada")
                    }
                }
            }
        }
    }
}
