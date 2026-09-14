package com.ronda.tarea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Tarea(
    val id: Int,
    val nombre: String,
    val completada: Boolean = false
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                PantallaTareasTecsup()
            }
        }
    }
}
@Composable
fun PantallaTareasTecsup() {
    val azulTecsup = Color(0xFF1B237E)
    val fondoPantalla = Color(0xFFF4F6FB)
    val colorIconoTacho = Color(0xFF8BBAC9)

    var textoTarea by remember { mutableStateOf("") }
    var contadorId by remember { mutableStateOf(5) }

    val listaTareas = remember {
        mutableStateListOf(
            Tarea(1, "Java"),
            Tarea(2, "Net"),
            Tarea(3, "Kotlin"),
            Tarea(4, "SQL")
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = fondoPantalla
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            // 1. Título principal
            Text(
                text = "Lista de tareas - Tecsup",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = azulTecsup,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 2. Campo de entrada (Input de texto)
            OutlinedTextField(
                value = textoTarea,
                onValueChange = { textoTarea = it },
                label = { Text("¿Qué tarea tienes pendiente?") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = azulTecsup,
                    unfocusedBorderColor = azulTecsup.copy(alpha = 0.5f),
                    focusedLabelColor = azulTecsup,
                    unfocusedLabelColor = Color.Gray
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 3. Botón para agregar tareas
            Button(
                onClick = {
                    if (textoTarea.isNotBlank()) {
                        listaTareas.add(
                            Tarea(
                                id = contadorId,
                                nombre = textoTarea.trim()
                            )
                        )
                        contadorId++
                        textoTarea = "" // Limpiar el input tras agregar
                    }
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = azulTecsup),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "Agregar tarea",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 4. Contador dinámico de tareas
            Text(
                text = "Total de tareas: ${listaTareas.size}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 5. Lista de tareas registradas
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(listaTareas, key = { it.id }) { tarea ->
                    ItemTareaTecsup(
                        tarea = tarea,
                        colorIconoTacho = colorIconoTacho,
                        onEliminar = {
                            listaTareas.remove(tarea)
                        },
                        onCambiarEstado = { completada ->
                            val index = listaTareas.indexOf(tarea)
                            if (index != -1) {
                                listaTareas[index] = listaTareas[index].copy(completada = completada)
                            }
                        }
                    )
                }
            }
        }
    }
}

