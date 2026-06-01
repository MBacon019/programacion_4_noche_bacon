// Paso02UiState_mp.kt — sealed class UiState · Consultas Médicas
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Paso02_UiState_mp(vm: ConsultasViewModel_mp = viewModel()) {
    val uiState  by vm.uiState.collectAsStateWithLifecycle()
    val busqueda by vm.busqueda.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "Paso02 · sealed class UiState — Consultas Médicas",
            style    = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )

        // Botones para simular los tres estados
        Row(
            modifier              = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick  = { vm.recargar() },
                modifier = Modifier.weight(1f)
            ) { Text("✓ Éxito") }

            OutlinedButton(
                onClick  = { vm.cargarConsultas(simularError = true) },
                modifier = Modifier.weight(1f),
                colors   = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.error
                )
            ) { Text("✗ Error") }
        }

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value         = busqueda,
            onValueChange = { vm.actualizarBusqueda(it) },
            placeholder   = { Text("Buscar consulta...") },
            leadingIcon   = { Icon(Icons.Default.Search, null) },
            trailingIcon  = {
                if (busqueda.isNotEmpty())
                    IconButton(onClick = { vm.actualizarBusqueda("") }) {
                        Icon(Icons.Default.Clear, "Limpiar")
                    }
            },
            singleLine = true,
            modifier   = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(8.dp))

        // when sobre sealed class — el compilador garantiza exhaustividad
        when (val estado = uiState) {

            // ── Loading ──────────────────────────────────────────────────────
            is UiState_mp.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator()
                        Spacer(Modifier.height(12.dp))
                        Text("Cargando consultas médicas...",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }

            // ── Error ────────────────────────────────────────────────────────
            is UiState_mp.Error -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier            = Modifier.padding(32.dp)
                    ) {
                        Icon(Icons.Default.WifiOff, null,
                            Modifier.size(56.dp),
                            tint = MaterialTheme.colorScheme.error)
                        Text(
                            text  = estado.message,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.error
                        )
                        Button(onClick = { vm.recargar() }) {
                            Icon(Icons.Default.Refresh, null)
                            Spacer(Modifier.width(8.dp))
                            Text("Reintentar")
                        }
                    }
                }
            }

            // ── Success ──────────────────────────────────────────────────────
            is UiState_mp.Success -> {
                Text(
                    "${estado.data.size} consulta(s)",
                    style    = MaterialTheme.typography.labelSmall,
                    color    = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
                LazyColumn(
                    contentPadding      = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(estado.data, key = { it.id }) { consulta ->
                        TarjetaConsultaSimple_mp(consulta = consulta)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso02_UiState_Preview_mp() {
    MaterialTheme { Paso02_UiState_mp() }
}
