// S02Text_mp.kt — Text con estilos · Consultas Médicas
package com.example.compose_mp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun S02Text_mp() {
    Column(
        modifier            = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("S02 · Text con estilos — Consultas Médicas",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        EtiquetaM("1. Información del paciente")
        Text("Ana Rodríguez — Cédula: 0912345678")

        EtiquetaM("2. Diagnóstico en negrita")
        Text("Diagnóstico: Hipertensión arterial", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Observación: En seguimiento",        fontSize = 16.sp, fontStyle  = FontStyle.Italic)
        Text("Clasificación: Grado I",             fontSize = 18.sp, fontWeight = FontWeight.Light)

        EtiquetaM("3. Estados con color")
        Text("Estado: URGENTE",   color = Color(0xFFD32F2F))
        Text("Estado: Atendida",  color = Color(0xFF388E3C), textDecoration = TextDecoration.Underline)
        Text("Estado: Cancelada", color = MaterialTheme.colorScheme.onSurfaceVariant,
            textDecoration = TextDecoration.LineThrough)

        EtiquetaM("4. Diagnóstico largo — maxLines")
        Text(
            text     = "El paciente presenta síntomas de hipertensión arterial grado II con episodios recurrentes de cefalea y mareos matutinos",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text     = "Se recomienda ajuste de medicación antihipertensiva y control de presión arterial cada 48 horas durante las próximas dos semanas",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        EtiquetaM("5. Escala tipográfica — ficha médica")
        Text("CARDIOLOGÍA",       style = MaterialTheme.typography.headlineMedium)
        Text("Dr. Carlos Méndez", style = MaterialTheme.typography.titleLarge)
        Text("Consultorio 101",   style = MaterialTheme.typography.bodyLarge)
        Text("Lun–Vie 08:00–16:00", style = MaterialTheme.typography.bodySmall)
        Text("Turno: #12",        style = MaterialTheme.typography.labelSmall)

        EtiquetaM("6. Alineación — encabezado de receta")
        Text(
            text      = "HOSPITAL GENERAL DEL NORTE",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier  = Modifier.fillMaxWidth()
        )
        Text(
            text      = "Fecha: 01/06/2025",
            textAlign = TextAlign.End,
            modifier  = Modifier.fillMaxWidth()
        )
    }
}

@Composable
internal fun EtiquetaM(texto: String) {
    Text(
        text  = texto,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.primary
    )
}

@Preview(showBackground = true)
@Composable
fun S02_Preview_mp() {
    MaterialTheme { S02Text_mp() }
}
