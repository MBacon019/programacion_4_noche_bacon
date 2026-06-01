// Paso01ViewModel_mp.kt — ViewModel + StateFlow · Consultas Médicas
package com.example.compose_mp.viewmodel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_mp.model.Consulta

@Composable
fun Paso01_ViewModel_mp(
    vm: ConsultasViewModel_mp = viewModel()
) {
    val consultas by vm.consultas.collectAsStateWithLifecycle()
    val busqueda  by vm.busqueda.collectAsStateWithLifecycle()
    val cargando  by vm.cargando.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "Paso01 · ViewModel + StateFlow — Consultas Médicas",
            style    = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )

        OutlinedTextField(
            value         = busqueda,
            onValueChange = { vm.actualizarBusqueda(it) },
            placeholder   = { Text("Buscar paciente, médico o especialidad...") },
            leadingIcon   = { Icon(Icons.Default.Search, null) },
            trailingIcon  = {
                if (busqueda.isNotEmpty())
                    IconButton(onClick = { vm.actualizarBusqueda("") }) {
                        Icon(Icons.Default.Clear, "Limpiar")
                    }
            },
            singleLine = true,
            modifier   = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        if (cargando) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }

        Text(
            "${consultas.size} consulta(s)",
            style    = MaterialTheme.typography.labelSmall,
            color    = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        )

        LazyColumn(
            contentPadding      = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(consultas, key = { it.id }) { consulta ->
                TarjetaConsultaSimple_mp(consulta = consulta)
            }
        }
    }
}

@Composable
internal fun TarjetaConsultaSimple_mp(
    consulta: Consulta,
    onClick:  () -> Unit = {}
) {
    val colorEstado = when (consulta.estado) {
        "Atendida"  -> Color(0xFF388E3C)
        "Cancelada" -> Color(0xFF757575)
        else        -> if (consulta.urgente) MaterialTheme.colorScheme.error
                       else MaterialTheme.colorScheme.primary
    }

    ElevatedCard(
        onClick  = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier              = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment     = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(consulta.paciente, fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleSmall)
                    if (consulta.urgente) {
                        Spacer(Modifier.width(6.dp))
                        Text("🚨", style = MaterialTheme.typography.labelSmall)
                    }
                }
                Text(consulta.medico,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(consulta.especialidad,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(consulta.hora,
                    style      = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color      = MaterialTheme.colorScheme.primary)
                AssistChip(
                    onClick = {},
                    label   = { Text(consulta.estado,
                        style = MaterialTheme.typography.labelSmall,
                        color = colorEstado) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01_ViewModel_Preview_mp() {
    MaterialTheme { Paso01_ViewModel_mp() }
}
