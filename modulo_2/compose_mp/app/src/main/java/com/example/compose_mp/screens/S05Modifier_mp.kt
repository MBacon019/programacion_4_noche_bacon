// S05Modifier_mp.kt — Modifier · Consultas Médicas
package com.example.compose_mp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S05Modifier_mp() {
    var ultimoClick by remember { mutableStateOf("Toca una especialidad") }

    Column(
        modifier            = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("S05 · Modifier — Consultas Médicas",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        Surface(
            color    = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(ultimoClick, Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodySmall)
        }

        EtiquetaM("1. Tarjeta de urgencia — clip + background + border")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFFFCDD2))
                .border(2.dp, Color(0xFFD32F2F), RoundedCornerShape(12.dp))
                .padding(16.dp)
                .clickable { ultimoClick = "Urgencia seleccionada 🚨" },
            contentAlignment = Alignment.Center
        ) {
            Text("🚨 URGENTE — Atención inmediata",
                fontWeight = FontWeight.Bold,
                color      = Color(0xFFD32F2F))
        }

        EtiquetaM("2. Estado sin recorte (error común)")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE8F5E9))
                .clip(RoundedCornerShape(12.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Atendida — background antes de clip ❌",
                color = Color(0xFF388E3C))
        }

        EtiquetaM("3. Avatares de especialidades — CircleShape + clickable")
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            listOf(
                "CAR" to Color(0xFFD32F2F),
                "PED" to Color(0xFF1976D2),
                "DER" to Color(0xFF388E3C)
            ).forEach { (sigla, color) ->
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(color)
                        .clickable { ultimoClick = "Especialidad: $sigla seleccionada" },
                    contentAlignment = Alignment.Center
                ) {
                    Text(sigla, color = Color.White,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold)
                }
            }
        }

        EtiquetaM("4. Encabezado de receta — fillMaxWidth + padding")
        Text(
            text     = "HOSPITAL GENERAL DEL NORTE — Receta Médica",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE3F2FD))
                .padding(horizontal = 24.dp, vertical = 10.dp),
            fontWeight = FontWeight.SemiBold
        )

        EtiquetaM("5. Turno fijo vs espacio disponible")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(Modifier.size(64.dp).background(Color(0xFFBBDEFB)),
                contentAlignment = Alignment.Center) {
                Text("Turno\n#12", style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold)
            }
            Box(Modifier.weight(1f).height(64.dp).background(Color(0xFFB3E5FC)),
                contentAlignment = Alignment.Center) {
                Text("Dr. Carlos Méndez — Cardiología",
                    style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S05_Preview_mp() {
    MaterialTheme { S05Modifier_mp() }
}
