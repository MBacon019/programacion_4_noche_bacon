// S03Button_mp.kt — Variantes de Button · Consultas Médicas
package com.example.compose_mp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S03_Button_mp() {
    var ultimaAccion by remember { mutableStateOf("(ninguna acción)") }

    Column(
        modifier            = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("S03 · Variantes de Button — Consultas Médicas",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        Surface(
            color    = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text     = "Última acción: $ultimaAccion",
                modifier = Modifier.padding(12.dp),
                style    = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(Modifier.height(4.dp))

        Button(
            onClick  = { ultimaAccion = "Agendar consulta" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Agendar consulta") }

        Button(
            onClick  = { ultimaAccion = "Consulta URGENTE agendada" },
            modifier = Modifier.fillMaxWidth(),
            colors   = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        ) {
            Icon(Icons.Default.Warning, null, Modifier.size(18.dp))
            Spacer(Modifier.width(8.dp))
            Text("Marcar como URGENTE")
        }

        OutlinedButton(
            onClick  = { ultimaAccion = "Ver historial clínico" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Ver historial clínico") }

        TextButton(
            onClick  = { ultimaAccion = "Ver receta" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Ver receta médica") }

        ElevatedButton(
            onClick  = { ultimaAccion = "Confirmación de cita enviada" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Confirmar cita") }

        FilledTonalButton(
            onClick  = { ultimaAccion = "Recordatorio enviado al paciente" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Enviar recordatorio") }

        Button(
            onClick  = {},
            enabled  = false,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Médico no disponible") }

        HorizontalDivider()

        EtiquetaM("Acciones rápidas — IconButton")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            IconButton(onClick = { ultimaAccion = "Llamar al paciente" }) {
                Icon(Icons.Default.Phone, "Llamar", tint = MaterialTheme.colorScheme.primary)
            }
            IconButton(onClick = { ultimaAccion = "Cancelar consulta" }) {
                Icon(Icons.Default.Cancel, "Cancelar", tint = MaterialTheme.colorScheme.error)
            }
            IconButton(onClick = { ultimaAccion = "Ver expediente" }) {
                Icon(Icons.Default.Description, "Expediente", tint = MaterialTheme.colorScheme.secondary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S03_Preview_mp() {
    MaterialTheme { S03_Button_mp() }
}
