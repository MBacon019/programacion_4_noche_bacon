// S08Bienvenida_mp.kt — Onboarding 3 pasos · Consultas Médicas
package com.example.compose_mp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun S08_Bienvenida_mp() {
    var paso by remember { mutableStateOf(1) }

    Column(
        modifier            = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (paso) {
            1 -> PasoEspecialidad(onSiguiente = { paso = 2 })
            2 -> PasoFecha(onSiguiente = { paso = 3 }, onVolver = { paso = 1 })
            3 -> PasoConfirmacion(onReiniciar = { paso = 1 })
        }
    }
}

// ── Paso 1: elegir especialidad ──────────────────────────────────────────────
@Composable
private fun PasoEspecialidad(onSiguiente: () -> Unit) {
    var especialidad by remember { mutableStateOf<String?>(null) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        IndicadorPasos_mp(pasoActual = 1, totalPasos = 3)
        Spacer(Modifier.height(8.dp))

        Text("Elige tu especialidad",
            style      = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold)
        Text("Selecciona el área médica que necesitas",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant)

        Spacer(Modifier.height(8.dp))

        listOf("Cardiología", "Pediatría", "Dermatología", "Neurología").forEach { esp ->
            val seleccionada = especialidad == esp
            Button(
                onClick  = { especialidad = esp },
                modifier = Modifier.fillMaxWidth(),
                colors   = if (seleccionada) ButtonDefaults.buttonColors()
                           else              ButtonDefaults.outlinedButtonColors()
            ) {
                Text(esp)
                if (seleccionada) {
                    Spacer(Modifier.width(8.dp)); Text("✓")
                }
            }
        }

        Spacer(Modifier.height(8.dp))
        Button(
            onClick  = onSiguiente,
            enabled  = especialidad != null,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape    = RoundedCornerShape(12.dp)
        ) { Text("Siguiente →") }
    }
}

// ── Paso 2: elegir horario ───────────────────────────────────────────────────
@Composable
private fun PasoFecha(onSiguiente: () -> Unit, onVolver: () -> Unit) {
    var turno by remember { mutableStateOf(1) }
    val maxTurnos = 8

    val horario = when (turno) {
        1 -> "08:00 — Primer turno"
        2 -> "08:30"
        3 -> "09:00"
        4 -> "09:30"
        5 -> "10:00"
        6 -> "10:30"
        7 -> "11:00"
        else -> "11:30 — Último turno"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        IndicadorPasos_mp(pasoActual = 2, totalPasos = 3)
        Spacer(Modifier.height(8.dp))

        Text("Selecciona el horario",
            style      = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold)

        Text(
            "Turno $turno de $maxTurnos",
            style      = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            color      = MaterialTheme.colorScheme.primary
        )
        Text(horario,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant)

        LinearProgressIndicator(
            progress = { turno.toFloat() / maxTurnos },
            modifier = Modifier.fillMaxWidth().height(8.dp).clip(RoundedCornerShape(4.dp))
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = { if (turno > 1) turno-- }, enabled = turno > 1)
            { Text("← Anterior") }
            Button(onClick = { if (turno < maxTurnos) turno++ }, enabled = turno < maxTurnos)
            { Text("Siguiente →") }
        }

        Spacer(Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = onVolver, modifier = Modifier.weight(1f)) { Text("← Volver") }
            Button(onClick = onSiguiente, modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp)) { Text("Confirmar →") }
        }
    }
}

// ── Paso 3: confirmación ─────────────────────────────────────────────────────
@Composable
private fun PasoConfirmacion(onReiniciar: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        IndicadorPasos_mp(pasoActual = 3, totalPasos = 3)
        Spacer(Modifier.height(8.dp))

        Box(
            modifier         = Modifier.size(88.dp).clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text("✓", style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color      = MaterialTheme.colorScheme.onPrimaryContainer)
        }

        Text("¡Cita agendada con éxito!",
            style      = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold)
        Text(
            "Tu consulta médica ha sido confirmada.\nRecibirás un recordatorio 1 hora antes.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onReiniciar, modifier = Modifier.fillMaxWidth()) {
            Text("↺ Agendar otra consulta")
        }
    }
}

@Composable
private fun IndicadorPasos_mp(pasoActual: Int, totalPasos: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        (1..totalPasos).forEach { paso ->
            Box(
                modifier = Modifier
                    .size(if (paso == pasoActual) 12.dp else 8.dp)
                    .clip(CircleShape)
                    .background(
                        if (paso <= pasoActual) MaterialTheme.colorScheme.primary
                        else                    MaterialTheme.colorScheme.surfaceVariant
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S08_Preview_mp() {
    MaterialTheme { S08_Bienvenida_mp() }
}
