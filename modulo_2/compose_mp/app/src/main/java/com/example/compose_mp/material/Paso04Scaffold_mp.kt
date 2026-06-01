// Paso04Scaffold_mp.kt — Scaffold + TopAppBar + FAB · Consultas Médicas
package com.example.compose_mp.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_mp.model.Consulta
import com.example.compose_mp.model.consultasDeMuestra

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paso04Scaffold_mp() {
    var consultas   by remember { mutableStateOf(consultasDeMuestra) }
    var busqueda    by remember { mutableStateOf("") }
    var filtroEstado by remember { mutableStateOf("Todas") }
    var mostrarFab  by remember { mutableStateOf(false) }

    val consultasFiltradas = consultas
        .filter { c -> if (filtroEstado != "Todas") c.estado == filtroEstado else true }
        .filter { c -> busqueda.isBlank() ||
            c.paciente.contains(busqueda, ignoreCase = true) ||
            c.medico.contains(busqueda, ignoreCase = true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Consultas (${consultas.size})", fontWeight = FontWeight.Bold)
                },
                actions = {
                    IconButton(onClick = {
                        val soloUrgentes = filtroEstado == "Urgentes"
                        filtroEstado = if (soloUrgentes) "Todas" else "Urgentes"
                    }) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "Urgentes",
                            tint = if (filtroEstado == "Urgentes")
                                MaterialTheme.colorScheme.error
                            else MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor    = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { mostrarFab = true }) {
                Icon(Icons.Default.Add, "Nueva consulta")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value         = busqueda,
                onValueChange = { busqueda = it },
                placeholder   = { Text("Buscar paciente o médico...") },
                leadingIcon   = { Icon(Icons.Default.Search, null) },
                trailingIcon  = {
                    if (busqueda.isNotEmpty())
                        IconButton(onClick = { busqueda = "" }) {
                            Icon(Icons.Default.Clear, "Limpiar")
                        }
                },
                singleLine = true,
                modifier   = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding        = PaddingValues(horizontal = 16.dp)
            ) {
                items(listOf("Todas", "Pendiente", "Atendida", "Cancelada")) { estado ->
                    FilterChip(
                        selected    = filtroEstado == estado,
                        onClick     = { filtroEstado = estado },
                        label       = { Text(estado) },
                        leadingIcon = if (filtroEstado == estado) {
                            { Icon(Icons.Default.Check, null,
                                Modifier.size(FilterChipDefaults.IconSize)) }
                        } else null
                    )
                }
            }

            Spacer(Modifier.height(4.dp))

            LazyColumn(
                contentPadding      = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text("${consultasFiltradas.size} consulta(s)",
                        style    = MaterialTheme.typography.labelSmall,
                        color    = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 4.dp))
                }
                items(consultasFiltradas, key = { it.id }) { consulta ->
                    TarjetaConsulta(
                        consulta  = consulta,
                        onCancelar = {
                            consultas = consultas.map { c ->
                                if (c.id == consulta.id) c.copy(estado = "Cancelada") else c
                            }
                        }
                    )
                }
                item { Spacer(Modifier.height(80.dp)) }
            }
        }
    }

    if (mostrarFab) {
        AlertDialog(
            onDismissRequest = { mostrarFab = false },
            title   = { Text("Nueva consulta") },
            text    = { Text("El formulario de nueva consulta se conectará en el Paso 6.") },
            confirmButton = {
                TextButton(onClick = { mostrarFab = false }) { Text("OK") }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Paso04_Preview_mp() {
    MaterialTheme { Paso04Scaffold_mp() }
}
