package com.ronda.tecsup_fit.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ronda.tecsup_fit.ui.theme.TecsupGreenLight
import com.ronda.tecsup_fit.ui.theme.TecsupGreenPrimary

data class Rutina(
    val id: Int,
    val nombre: String,
    val nivel: String,
)

val rutinas: List<Rutina> = listOf(
    Rutina(1, "Yoga funcional", "Nivel Principiante"),
    Rutina(2, "Cross Training", "Nivel Avanzado"),
    Rutina(3, "Spinning Cardio", "Nivel Intermedio"),
)

@Composable
fun RoutinesScreen(
    @Suppress("UNUSED_PARAMETER") navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp),
    ) {
        Text(
            text = "Rutinas",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(rutinas) { rutina ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF0F3F1),
                    ),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(TecsupGreenLight),
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                imageVector = Icons.Default.FitnessCenter,
                                contentDescription = "Rutina",
                                tint = TecsupGreenPrimary,
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = rutina.nombre,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = rutina.nivel,
                                color = Color.Gray,
                                fontSize = 13.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}
