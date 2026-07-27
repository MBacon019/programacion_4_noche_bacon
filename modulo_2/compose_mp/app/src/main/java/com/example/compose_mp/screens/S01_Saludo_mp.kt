// S01_Saludo_mp.kt — @Composable básico · Consultas Médicas
package com.example.compose_mp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SaludoMedico(nombre: String, rol: String) {
    Text(text = "Bienvenido/a, $nombre — $rol")
}

@Composable
fun S01_Saludo_mp() {
    Column(
        modifier            = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("S01 · @Composable básico — Consultas Médicas",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        // El mismo composable con distintos argumentos
        SaludoMedico("Dr. Carlos Méndez", "Cardiólogo")
        SaludoMedico("Dra. María Vega",   "Pediatra")
        SaludoMedico("Ana Rodríguez",     "Paciente")

        HorizontalDivider()

        EstadoConsulta(urgente = true)
        EstadoConsulta(urgente = false)
    }
}

@Composable
private fun EstadoConsulta(urgente: Boolean) {
    if (urgente) {
        Text("🚨 URGENTE — atención inmediata",
            color = MaterialTheme.colorScheme.error)
    } else {
        Text("✅ Consulta programada — cita confirmada",
            color = MaterialTheme.colorScheme.primary)
    }
}

@Preview(showBackground = true)
@Composable
fun S01_Preview_mp() {
    MaterialTheme { S01_Saludo_mp() }
}
