// S04Layout_mp.kt — Column / Row / Box · Consultas Médicas
package com.example.compose_mp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S04_Layout_mp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("S04 · Column / Row / Box — Consultas Médicas",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        // ── COLUMN: datos del paciente ─────────────────────────────────────
        EtiquetaM("Column — ficha del paciente")
        Column(
            modifier            = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE3F2FD))
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CeldaMedica("Paciente",      "Ana Rodríguez",   Color(0xFF90CAF9))
            CeldaMedica("Cédula",        "0912345678",      Color(0xFF64B5F6))
            CeldaMedica("Especialidad",  "Cardiología",     Color(0xFF42A5F5))
        }

        // ── ROW: médico y consultorio ──────────────────────────────────────
        EtiquetaM("Row — cabecera de cita (SpaceBetween)")
        Row(
            modifier              = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF3E5F5))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment     = Alignment.CenterVertically
        ) {
            Text("Dr. Carlos Méndez", fontWeight = FontWeight.Bold)
            Text("Cardiólogo")
            Text("Consultorio 101")
        }

        EtiquetaM("Row — estados de consulta (SpaceEvenly)")
        Row(
            modifier              = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE8F5E9))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Pendiente"); Text("Atendida"); Text("Cancelada"); Text("Urgente")
        }

        // ── ROW con weight: distribución del horario ───────────────────────
        EtiquetaM("Row + weight — horario del día (1:2:1)")
        Row(Modifier.fillMaxWidth().height(50.dp)) {
            Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFFEF9A9A)),
                contentAlignment = Alignment.Center) { Text("Mañana") }
            Box(Modifier.weight(2f).fillMaxHeight().background(Color(0xFFE57373)),
                contentAlignment = Alignment.Center) { Text("Tarde (mayor demanda)") }
            Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFFEF5350)),
                contentAlignment = Alignment.Center) { Text("Noche") }
        }

        // ── BOX: panel de estado con superposición ─────────────────────────
        EtiquetaM("Box — panel de urgencias (capas superpuestas)")
        Box(
            modifier         = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(0xFF1565C0)),
            contentAlignment = Alignment.Center
        ) {
            Box(Modifier.size(40.dp).background(Color(0xFFD32F2F))
                .align(Alignment.TopStart))
            Box(Modifier.size(40.dp).background(Color(0xFF42A5F5))
                .align(Alignment.BottomEnd))
            Text("SALA DE ESPERA — 5 pacientes",
                color = Color.White,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun CeldaMedica(etiqueta: String, valor: String, color: Color) {
    Box(
        modifier         = Modifier.fillMaxWidth().height(36.dp).background(color),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text("$etiqueta: ", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
            Text(valor, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S04_Preview_mp() {
    MaterialTheme { S04_Layout_mp() }
}
