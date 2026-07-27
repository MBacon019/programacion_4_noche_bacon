// Paso02Card_mp.kt — Card y ElevatedCard · Consultas Médicas
package com.example.compose_mp.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_mp.model.Consulta
import com.example.compose_mp.model.consultasDeMuestra

// ── Tarjeta de consulta reutilizable ────────────────────────────────────────
@Composable
fun TarjetaConsulta(
    consulta:   Consulta,
    onClick:    () -> Unit = {},
    onLlamar:   () -> Unit = {},
    onCancelar: () -> Unit = {}
) {
    val colorEstado = when (consulta.estado) {
        "Atendida"  -> Color(0xFF388E3C)
        "Cancelada" -> Color(0xFF757575)
        else        -> if (consulta.urgente) Color(0xFFD32F2F)
                       else MaterialTheme.colorScheme.primary
    }

    ElevatedCard(
        onClick  = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier          = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar con inicial del paciente
            Box(
                modifier         = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text       = consulta.paciente.first().uppercase(),
                    style      = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color      = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(consulta.paciente,
                        style      = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold)
                    if (consulta.urgente) {
                        Spacer(Modifier.width(6.dp))
                        Text("🚨", style = MaterialTheme.typography.labelSmall)
                    }
                }
                Text(consulta.medico,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text("${consulta.especialidad} · ${consulta.hora}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(4.dp))
                AssistChip(
                    onClick = {},
                    label   = { Text(consulta.estado,
                        style = MaterialTheme.typography.labelSmall,
                        color = colorEstado) }
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = onLlamar) {
                    Icon(Icons.Default.Phone, null, tint = MaterialTheme.colorScheme.primary)
                }
                if (consulta.estado == "Pendiente") {
                    IconButton(onClick = onCancelar) {
                        Icon(Icons.Default.Cancel, null, tint = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }
    }
}

// ── Screen del Paso 2 ────────────────────────────────────────────────────────
@Composable
fun Paso02_Card_mp() {
    Column(
        modifier            = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Paso02 · Card — Consultas Médicas",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        Text("ElevatedCard — tarjeta de consulta",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary)

        consultasDeMuestra.take(3).forEach { consulta ->
            TarjetaConsulta(consulta = consulta)
        }

        HorizontalDivider()
        Text("Variantes de Card",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary)

        Card(modifier = Modifier.fillMaxWidth()) {
            Text("Card — receta médica (sin elevación)", Modifier.padding(16.dp))
        }
        ElevatedCard(modifier = Modifier.fillMaxWidth()) {
            Text("ElevatedCard — ficha de paciente (con sombra)", Modifier.padding(16.dp))
        }
        OutlinedCard(modifier = Modifier.fillMaxWidth()) {
            Text("OutlinedCard — resultado de examen (solo borde)", Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso02_Card_Preview_mp() {
    MaterialTheme { Paso02_Card_mp() }
}
