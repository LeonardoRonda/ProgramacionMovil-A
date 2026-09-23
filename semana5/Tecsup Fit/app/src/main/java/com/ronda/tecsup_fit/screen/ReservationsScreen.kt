package com.ronda.tecsup_fit.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ronda.tecsup_fit.ui.theme.CompletadaGrayBg
import com.ronda.tecsup_fit.ui.theme.CompletadaGrayText
import com.ronda.tecsup_fit.ui.theme.ConfirmadaGreenBg
import com.ronda.tecsup_fit.ui.theme.ConfirmadaGreenText
import com.ronda.tecsup_fit.ui.theme.TecsupGreenPrimary

data class ReservaItem(
    val id: Int,
    val nombre: String,
    val fechaHora: String,
    val estado: String, // "Confirmada" or "Completada"
)

val reservadas: List<ReservaItem> = listOf(
    ReservaItem(
        id = 1,
        nombre = "Cross Training",
        fechaHora = "Hoy, 6:00 pm",
        estado = "Confirmada",
    ),
    ReservaItem(
        id = 2,
        nombre = "Yoga funcional",
        fechaHora = "Ayer, 7:00 am",
        estado = "Completada",
    ),
)

@Composable
fun ReservationsScreen(
    @Suppress("UNUSED_PARAMETER") navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp),
    ) {
        Text(
            text = "Mis reservas",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(reservadas) { reserva ->
                val isConfirmada = reserva.estado == "Confirmada"

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
                            .height(IntrinsicSize.Min),
                    ) {
                        // Vertical accent bar on left for Confirmada
                        if (isConfirmada) {
                            Box(
                                modifier = Modifier
                                    .width(5.dp)
                                    .fillMaxHeight()
                                    .background(TecsupGreenPrimary),
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                        ) {
                            Text(
                                text = reserva.nombre,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = reserva.fechaHora,
                                color = Color.Gray,
                                fontSize = 13.sp,
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            // Status badge
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        if (isConfirmada) ConfirmadaGreenBg else CompletadaGrayBg,
                                    )
                                    .padding(horizontal = 12.dp, vertical = 4.dp),
                            ) {
                                Text(
                                    text = reserva.estado,
                                    color = if (isConfirmada) ConfirmadaGreenText else CompletadaGrayText,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
