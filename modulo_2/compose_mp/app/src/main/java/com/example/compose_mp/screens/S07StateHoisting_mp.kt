// S07StateHoisting_mp.kt — State Hoisting · Consultas Médicas
package com.example.compose_mp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S07_StateHoisting_mp() {
    Column(
        modifier            = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("S07 · State Hoisting — Consultas Médicas",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        EstadoAtrapado()
        HorizontalDivider()
        EstadoElevado()
    }
}

// ── ❌ Anti-patrón: estado atrapado en el componente ─────────────────────────
@Composable
private fun EstadoAtrapado() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        EtiquetaM("❌ Estado atrapado — el padre no sabe la especialidad elegida")
        Text(
            "El paciente elige especialidad dentro del botón. " +
            "La pantalla principal no puede mostrar el médico disponible.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        SelectorAtrapado()
        Text(
            "La pantalla no puede mostrar médicos disponibles ❌",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
private fun SelectorAtrapado() {
    var especialidad by remember { mutableStateOf("(sin selección)") }
    Button(onClick = {
        especialidad = if (especialidad == "Cardiología") "Pediatría" else "Cardiología"
    }) {
        Text("Especialidad seleccionada: $especialidad (atrapada)")
    }
}

// ── ✅ Patrón correcto: estado elevado al padre ──────────────────────────────
@Composable
private fun EstadoElevado() {
    var especialidad by remember { mutableStateOf<String?>(null) }
    var historial    by remember { mutableStateOf(listOf<String>()) }

    val especialidades = listOf("Cardiología", "Pediatría", "Dermatología", "Neurología")

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        EtiquetaM("✅ Estado elevado — la pantalla coordina especialidad y médico")
        Text(
            "El hijo solo notifica qué especialidad tocó. " +
            "El padre muestra el médico disponible Y actualiza el historial.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        SelectorEspecialidad(
            especialidades = especialidades,
            seleccion      = especialidad,
            onSeleccion    = { opcion ->
                especialidad = opcion
                historial    = (historial + opcion).takeLast(4)
            }
        )

        // El padre usa el estado para mostrar el médico correspondiente
        especialidad?.let { esp ->
            val (medico, color) = when (esp) {
                "Cardiología"  -> "Dr. Carlos Méndez — Consultorio 101" to Color(0xFFFFCDD2)
                "Pediatría"    -> "Dra. María Vega  — Consultorio 102"  to Color(0xFFBBDEFB)
                "Dermatología" -> "Dr. Juan López   — NO DISPONIBLE"    to Color(0xFFFFECB3)
                else           -> "Dr. Luis Herrera — Consultorio 106"  to Color(0xFFC8E6C9)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color),
                contentAlignment = Alignment.Center
            ) { Text(medico, style = MaterialTheme.typography.labelLarge) }
        }

        if (historial.isNotEmpty()) {
            Text(
                "Historial: ${historial.joinToString(" → ")}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SelectorEspecialidad(
    especialidades: List<String>,
    seleccion:      String?,
    onSeleccion:    (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        especialidades.forEach { opcion ->
            val activo = seleccion == opcion
            Button(
                onClick  = { onSeleccion(opcion) },
                modifier = Modifier.fillMaxWidth(),
                colors   = if (activo) ButtonDefaults.buttonColors()
                           else        ButtonDefaults.outlinedButtonColors()
            ) { Text(opcion) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S07_Preview_mp() {
    MaterialTheme { S07_StateHoisting_mp() }
}
