package com.ronda.tarealab3


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ronda.tarealab3.ui.theme.TareaLab3Theme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TareaLab3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaRegistroNotas(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaRegistroNotas(modifier: Modifier = Modifier){
    var notaFunProg by remember { mutableFloatStateOf(0f) }
    var notaPoo by remember { mutableFloatStateOf(0f) }
    var notaMovil by remember { mutableFloatStateOf(0f) }
    var notaBd by remember { mutableFloatStateOf(0f) }

    var redondear by remember { mutableStateOf(false) }
    var confirmado by remember { mutableStateOf(false) }
    val colorsDegradado = listOf(
        Color(0xFF7F00FD),
        Color(0xFF43007C)
    )
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFB983F6),
                        Color(0xFFC3ABFF)
                    )
                )
            )
            .verticalScroll(rememberScrollState())

    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = Brush.horizontalGradient(colors = colorsDegradado))
                .padding(vertical = 16.dp, horizontal = 20.dp)
        ) {
            Text(
                text = "Registro de Notas",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Notas del ciclo",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = "Desliza para asignar cada nota (0 a 20)",
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Controles de Cursos
            Curso("Fundamentos de Programación", 20, notaFunProg) { notaFunProg = it }
            Curso("Programación Orientada a Objetos", 25, notaPoo) { notaPoo = it }
            Curso("Programación en Móviles", 30, notaMovil) { notaMovil = it }
            Curso("Base de Datos", 25, notaBd) { notaBd = it }

            Spacer(modifier = Modifier.height(12.dp))

            // Control Switch
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Redondear promedio final", fontSize = 13.sp, color = Color.DarkGray)
                Switch(
                    checked = redondear,
                    onCheckedChange = { redondear = it }
                )
            }
        }
    }
}

@Composable
fun Curso(
    nombre : String,
    peso: Int,
    nota: Float,
    onNotaChange: (Float) -> Unit
    ) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$nombre ($peso%)",
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp
            )
            Text(
                text = "${nota.toInt()}",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFF6B21A8)
            )
        }
        Slider(
            value = nota,
            onValueChange = onNotaChange,
            valueRange = 0f..20f,
            steps = 19
        )
    }
}

