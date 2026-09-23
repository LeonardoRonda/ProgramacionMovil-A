package com.ronda.tecsup_fit.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ronda.tecsup_fit.navigation.Screen

data class Clase(
    val id: Int,
    val nombre: String,
    val hora: String,
    val sala: String,
)

val clases: List<Clase> = listOf(
    Clase(1, "Yoga funcional", "7:00 am", "Sala 2"),
    Clase(2, "Cross Training", "6:00 pm", "Sala 1"),
    Clase(3, "Spinning", "7:30 pm", "Sala 3"),
)

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        Text(
            text = "TECSUP Fit",
            style = MaterialTheme.typography.headlineMedium,
        )

        Text("Hola, Diego")

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow {
            items(listOf("Hoy", "Esta semana")) { filtro ->

                AssistChip(
                    onClick = {},
                    label = {
                        Text(filtro)
                    },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Clases disponibles",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {

            items(clases) { clase ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clickable {
                            navController.navigate(
                                Screen.Detail.createRoute(clase.id)
                            )
                        }
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = clase.nombre,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(
                            text = "${clase.hora} • ${clase.sala}"
                        )
                    }
                }
            }
        }
    }
}
