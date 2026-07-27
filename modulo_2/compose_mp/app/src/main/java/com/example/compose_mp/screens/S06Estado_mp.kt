// S06Estado_mp.kt — Estado y recomposición · Consultas Médicas
package com.example.compose_mp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S06Estado_mp() {
    Column(
        modifier            = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("S06 · Estado y recomposición — Consultas Médicas",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        ContadorPacientes()
        HorizontalDivider()
        NivelOcupacion()
    }
}

// ── Demo 1: contador de pacientes en sala de espera ─────────────────────────
@Composable
private fun ContadorPacientes() {
    var enEspera by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        EtiquetaM("Sala de espera — remember + mutableStateOf")

        Text(
            text       = "$enEspera",
            style      = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            color      = if (enEspera >= 5) MaterialTheme.colorScheme.error
                         else MaterialTheme.colorScheme.primary
        )
        Text(
            "paciente(s) en espera",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick  = { if (enEspera > 0) enEspera-- }) { Text("Llamar siguiente") }
            Button(onClick  = { enEspera++ })                    { Text("Nuevo paciente +") }
            OutlinedButton(onClick = { enEspera = 0 })           { Text("Limpiar") }
        }

        Text(
            "Solo el número se recompone al cambiar",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// ── Demo 2: nivel de ocupación — estado derivado ─────────────────────────────
@Composable
private fun NivelOcupacion() {
    var ocupados by remember { mutableStateOf(0) }
    val capacidad = 10

    // Estado derivado: calculado de 'ocupados', sin mutableStateOf propio
    val porcentaje    = ocupados.toFloat() / capacidad
    val nivelEtiqueta = when {
        ocupados == 0             -> "Sin ocupación"
        ocupados <= 3             -> "Capacidad baja"
        ocupados <= 6             -> "Capacidad media"
        ocupados <= 8             -> "Alta demanda"
        else                     -> "Máxima capacidad"
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        EtiquetaM("Ocupación del hospital — estado derivado")

        Text(
            "$nivelEtiqueta ($ocupados/$capacidad camas)",
            style      = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        LinearProgressIndicator(
            progress = { porcentaje },
            modifier = Modifier
                .fillMaxWidth()
                .height(14.dp)
                .clip(RoundedCornerShape(7.dp))
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(
                onClick  = { if (ocupados > 0) ocupados-- },
                enabled  = ocupados > 0
            ) { Text("Alta médica −") }

            Button(
                onClick  = { if (ocupados < capacidad) ocupados++ },
                enabled  = ocupados < capacidad
            ) { Text("Ingreso +") }
        }

        Text(
            "Ocupación: ${"%.0f".format(porcentaje * 100)}% — derivado de 'ocupados'",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun S06_Preview_mp() {
    MaterialTheme { S06Estado_mp() }
}
