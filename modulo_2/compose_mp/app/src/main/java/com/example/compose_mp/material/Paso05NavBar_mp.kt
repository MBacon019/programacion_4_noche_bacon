// Paso05NavBar_mp.kt — NavigationBar · Consultas Médicas
package com.example.compose_mp.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_mp.model.Consulta
import com.example.compose_mp.model.Medico
import com.example.compose_mp.model.consultasDeMuestra
import com.example.compose_mp.model.medicosDeMuestra

data class DestinoMedico(
    val ruta:          String,
    val etiqueta:      String,
    val iconoActivo:   ImageVector,
    val iconoInactivo: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paso05NavBar_mp() {
    var destinoActual by remember { mutableStateOf("consultas") }
    var consultas     by remember { mutableStateOf(consultasDeMuestra) }

    val destinos = listOf(
        DestinoMedico("consultas", "Consultas",  Icons.Filled.MedicalServices, Icons.Outlined.MedicalServices),
        DestinoMedico("medicos",   "Médicos",    Icons.Filled.People,          Icons.Outlined.People),
        DestinoMedico("perfil",    "Mi perfil",  Icons.Filled.AccountCircle,   Icons.Outlined.AccountCircle),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sistema de Consultas", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor    = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                destinos.forEach { destino ->
                    val seleccionado = destinoActual == destino.ruta
                    NavigationBarItem(
                        selected = seleccionado,
                        onClick  = { destinoActual = destino.ruta },
                        icon     = {
                            Icon(
                                imageVector        = if (seleccionado) destino.iconoActivo
                                                     else destino.iconoInactivo,
                                contentDescription = destino.etiqueta
                            )
                        },
                        label = { Text(destino.etiqueta) }
                    )
                }
            }
        },
        floatingActionButton = {
            if (destinoActual == "consultas") {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Default.Add, "Nueva consulta")
                }
            }
        }
    ) { paddingValues ->
        when (destinoActual) {
            "consultas" -> PantallaConsultasContent(
                consultas  = consultas,
                modifier   = Modifier.padding(paddingValues)
            )
            "medicos"   -> PantallaMedicosContent(
                medicos  = medicosDeMuestra,
                modifier = Modifier.padding(paddingValues)
            )
            "perfil"    -> PantallaPerfilMedico(modifier = Modifier.padding(paddingValues))
        }
    }
}

@Composable
private fun PantallaConsultasContent(consultas: List<Consulta>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier            = modifier,
        contentPadding      = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(consultas, key = { it.id }) { consulta ->
            TarjetaConsulta(consulta = consulta)
        }
        item { Spacer(Modifier.height(80.dp)) }
    }
}

@Composable
fun PantallaMedicosContent(medicos: List<Medico>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier            = modifier,
        contentPadding      = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(medicos, key = { it.id }) { medico ->
            ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier          = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Person, null,
                        Modifier.size(40.dp),
                        tint = if (medico.disponible) MaterialTheme.colorScheme.primary
                               else MaterialTheme.colorScheme.onSurfaceVariant)
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text(medico.nombre, fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.titleSmall)
                        Text(medico.especialidad,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(medico.consultorio,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    AssistChip(
                        onClick = {},
                        label   = { Text(if (medico.disponible) "Disponible" else "No disponible",
                            style = MaterialTheme.typography.labelSmall) }
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaPerfilMedico(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.AccountCircle, null, Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.height(12.dp))
            Text("Dr. Usuario Actual",
                style      = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold)
            Text("Médico General — Consultorio 100",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(Modifier.height(8.dp))
            Text("Próximamente...",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso05_Preview_mp() {
    MaterialTheme { Paso05NavBar_mp() }
}
