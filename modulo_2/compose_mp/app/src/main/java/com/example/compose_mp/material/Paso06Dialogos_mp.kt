// Paso06Dialogos_mp.kt — Diálogos + Snackbar · Consultas Médicas
package com.example.compose_mp.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.compose_mp.model.Consulta
import com.example.compose_mp.model.consultasDeMuestra

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paso06Dialogos_mp() {
    var consultas          by remember { mutableStateOf(consultasDeMuestra) }
    var busqueda           by remember { mutableStateOf("") }
    var filtro             by remember { mutableStateOf("Todas") }
    var destinoActual      by remember { mutableStateOf("consultas") }
    var mostrarNueva       by remember { mutableStateOf(false) }
    var consultaACancelar  by remember { mutableStateOf<Consulta?>(null) }
    var mensajeSnack       by remember { mutableStateOf<String?>(null) }
    val snackbarHostState  = remember { SnackbarHostState() }

    LaunchedEffect(mensajeSnack) {
        mensajeSnack?.let {
            snackbarHostState.showSnackbar(it)
            mensajeSnack = null
        }
    }

    val consultasFiltradas = consultas
        .filter { c -> if (filtro != "Todas") c.estado == filtro || (filtro == "Urgentes" && c.urgente) else true }
        .filter { c -> busqueda.isBlank() ||
                c.paciente.contains(busqueda, ignoreCase = true) ||
                c.medico.contains(busqueda, ignoreCase = true) }

    val destinos = listOf(
        DestinoMedico("consultas", "Consultas", Icons.Filled.MedicalServices, Icons.Outlined.MedicalServices),
        DestinoMedico("medicos",   "Médicos",   Icons.Filled.People,          Icons.Outlined.People),
        DestinoMedico("perfil",    "Perfil",    Icons.Filled.AccountCircle,   Icons.Outlined.AccountCircle),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agenda (${consultas.size})", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = {
                        filtro = if (filtro == "Urgentes") "Todas" else "Urgentes"
                    }) {
                        Icon(Icons.Default.Warning,
                            contentDescription = "Urgentes",
                            tint = if (filtro == "Urgentes") MaterialTheme.colorScheme.error
                                   else MaterialTheme.colorScheme.onPrimaryContainer)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor    = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                destinos.forEach { destino ->
                    val sel = destinoActual == destino.ruta
                    NavigationBarItem(
                        selected = sel,
                        onClick  = { destinoActual = destino.ruta },
                        icon     = { Icon(if (sel) destino.iconoActivo else destino.iconoInactivo, destino.etiqueta) },
                        label    = { Text(destino.etiqueta) }
                    )
                }
            }
        },
        floatingActionButton = {
            if (destinoActual == "consultas") {
                FloatingActionButton(onClick = { mostrarNueva = true }) {
                    Icon(Icons.Default.Add, "Nueva consulta")
                }
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        when (destinoActual) {
            "consultas" -> ContenidoConsultas(
                consultas    = consultasFiltradas,
                busqueda     = busqueda,
                filtro       = filtro,
                onBusqueda   = { busqueda = it },
                onFiltro     = { filtro = it },
                onLlamar     = { nombre -> mensajeSnack = "📞 Llamando a $nombre..." },
                onCancelar   = { consulta -> consultaACancelar = consulta },
                modifier     = Modifier.padding(paddingValues)
            )
            "medicos"   -> PantallaMedicosContent(
                medicos  = com.example.compose_mp.model.medicosDeMuestra,
                modifier = Modifier.padding(paddingValues)
            )
            "perfil"    -> PantallaPerfilMedico(modifier = Modifier.padding(paddingValues))
        }
    }

    // Diálogo: nueva consulta
    if (mostrarNueva) {
        DialogNuevaConsulta(
            onDismiss = { mostrarNueva = false },
            onGuardar = { nueva ->
                consultas    = consultas + nueva
                mostrarNueva = false
                mensajeSnack = "✅ Consulta de ${nueva.paciente} agendada"
            }
        )
    }

    // AlertDialog: confirmar cancelación
    consultaACancelar?.let { consulta ->
        AlertDialog(
            onDismissRequest = { consultaACancelar = null },
            icon    = { Icon(Icons.Default.Warning, null, tint = MaterialTheme.colorScheme.error) },
            title   = { Text("Cancelar consulta") },
            text    = { Text("¿Seguro que deseas cancelar la consulta de ${consulta.paciente}?") },
            confirmButton = {
                Button(
                    onClick = {
                        consultas = consultas.map { c ->
                            if (c.id == consulta.id) c.copy(estado = "Cancelada") else c
                        }
                        mensajeSnack     = "🗑 Consulta de ${consulta.paciente} cancelada"
                        consultaACancelar = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) { Text("Cancelar cita") }
            },
            dismissButton = {
                OutlinedButton(onClick = { consultaACancelar = null }) { Text("Mantener") }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ContenidoConsultas(
    consultas:  List<Consulta>,
    busqueda:   String,
    filtro:     String,
    onBusqueda: (String) -> Unit,
    onFiltro:   (String) -> Unit,
    onLlamar:   (String) -> Unit,
    onCancelar: (Consulta) -> Unit,
    modifier:   Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        OutlinedTextField(
            value         = busqueda,
            onValueChange = onBusqueda,
            placeholder   = { Text("Buscar paciente o médico...") },
            leadingIcon   = { Icon(Icons.Default.Search, null) },
            trailingIcon  = {
                if (busqueda.isNotEmpty())
                    IconButton(onClick = { onBusqueda("") }) { Icon(Icons.Default.Clear, "Limpiar") }
            },
            singleLine = true,
            modifier   = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding        = PaddingValues(horizontal = 16.dp)
        ) {
            items(listOf("Todas", "Pendiente", "Atendida", "Cancelada", "Urgentes")) { opcion ->
                FilterChip(
                    selected    = filtro == opcion,
                    onClick     = { onFiltro(opcion) },
                    label       = { Text(opcion) },
                    leadingIcon = if (filtro == opcion) {
                        { Icon(Icons.Default.Check, null, Modifier.size(FilterChipDefaults.IconSize)) }
                    } else null
                )
            }
        }

        Spacer(Modifier.height(4.dp))

        if (consultas.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.SearchOff, null, Modifier.size(56.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    Spacer(Modifier.height(8.dp))
                    Text("Sin resultados", style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        } else {
            LazyColumn(
                contentPadding      = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text("${consultas.size} consulta(s)",
                        style    = MaterialTheme.typography.labelSmall,
                        color    = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 4.dp))
                }
                items(consultas, key = { it.id }) { consulta ->
                    TarjetaConsultaCompleta(
                        consulta   = consulta,
                        onLlamar   = { onLlamar(consulta.paciente) },
                        onCancelar = { onCancelar(consulta) }
                    )
                }
                item { Spacer(Modifier.height(100.dp)) }
            }
        }
    }
}

@Composable
private fun TarjetaConsultaCompleta(
    consulta:  Consulta,
    onLlamar:  () -> Unit,
    onCancelar: () -> Unit
) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(52.dp).clip(CircleShape)
                    .background(
                        if (consulta.urgente) MaterialTheme.colorScheme.errorContainer
                        else MaterialTheme.colorScheme.primaryContainer
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(consulta.paciente.first().uppercase(),
                    style      = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color      = if (consulta.urgente) MaterialTheme.colorScheme.onErrorContainer
                                 else MaterialTheme.colorScheme.onPrimaryContainer)
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(consulta.paciente, fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleSmall)
                    if (consulta.urgente) { Spacer(Modifier.width(4.dp)); Text("🚨") }
                }
                Text(consulta.medico, style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text("${consulta.especialidad} · ${consulta.fecha} ${consulta.hora}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text("Estado: ${consulta.estado}", style = MaterialTheme.typography.labelSmall)
            }
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

@Composable
private fun DialogNuevaConsulta(onDismiss: () -> Unit, onGuardar: (Consulta) -> Unit) {
    var paciente     by remember { mutableStateOf("") }
    var cedula       by remember { mutableStateOf("") }
    var especialidad by remember { mutableStateOf("Cardiología") }
    var hora         by remember { mutableStateOf("") }

    val valido = paciente.trim().length >= 3 && cedula.length == 10 && hora.isNotBlank()

    Dialog(onDismissRequest = onDismiss) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier            = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Nueva consulta", style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold)

                OutlinedTextField(
                    value         = paciente,
                    onValueChange = { paciente = it },
                    label         = { Text("Nombre del paciente") },
                    leadingIcon   = { Icon(Icons.Default.Person, null) },
                    singleLine    = true,
                    modifier      = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
                )

                OutlinedTextField(
                    value           = cedula,
                    onValueChange   = { cedula = it },
                    label           = { Text("Cédula (10 dígitos)") },
                    leadingIcon     = { Icon(Icons.Default.Badge, null) },
                    singleLine      = true,
                    modifier        = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next)
                )

                OutlinedTextField(
                    value           = hora,
                    onValueChange   = { hora = it },
                    label           = { Text("Hora (ej: 09:30)") },
                    leadingIcon     = { Icon(Icons.Default.Schedule, null) },
                    singleLine      = true,
                    modifier        = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                )

                Row(
                    modifier              = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) { Text("Cancelar") }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        onClick = {
                            onGuardar(Consulta(
                                id           = System.currentTimeMillis().toInt(),
                                paciente     = paciente.trim(),
                                cedula       = cedula,
                                medico       = "Por asignar",
                                especialidad = especialidad,
                                fecha        = "2025-06-01",
                                hora         = hora
                            ))
                        },
                        enabled = valido
                    ) { Text("Guardar") }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso06_Preview_mp() {
    MaterialTheme { Paso06Dialogos_mp() }
}
