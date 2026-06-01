// Paso01TextField_mp.kt — TextField · Registro de paciente
package com.example.compose_mp.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Paso01_TextField_mp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Paso01 · TextField — Registro de Paciente",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        BuscadorConsultas()
        HorizontalDivider()
        FormularioPaciente()
    }
}

// ── Buscador de consultas ────────────────────────────────────────────────────
@Composable
private fun BuscadorConsultas() {
    var busqueda by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Buscador de consultas",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        OutlinedTextField(
            value         = busqueda,
            onValueChange = { busqueda = it },
            placeholder   = { Text("Buscar por paciente o médico...") },
            leadingIcon   = { Icon(Icons.Default.Search, null) },
            trailingIcon  = {
                if (busqueda.isNotEmpty())
                    IconButton(onClick = { busqueda = "" }) {
                        Icon(Icons.Default.Clear, "Limpiar")
                    }
            },
            singleLine = true,
            modifier   = Modifier.fillMaxWidth()
        )
        Text(
            if (busqueda.isBlank()) "Escribe para filtrar consultas"
            else "Buscando: \"$busqueda\"",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// ── Formulario de registro de paciente ──────────────────────────────────────
@Composable
private fun FormularioPaciente() {
    var nombre   by remember { mutableStateOf("") }
    var cedula   by remember { mutableStateOf("") }
    var email    by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var motivo   by remember { mutableStateOf("") }

    val nombreValido  = nombre.trim().length >= 3
    val cedulaValida  = cedula.length == 10 && cedula.all { it.isDigit() }
    val emailValido   = email.contains("@") && email.contains(".")
    val telValido     = telefono.length >= 7
    val motivoValido  = motivo.trim().length >= 5
    val formValido    = nombreValido && cedulaValida && emailValido && telValido && motivoValido

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Registro de nuevo paciente",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        OutlinedTextField(
            value           = nombre,
            onValueChange   = { nombre = it },
            label           = { Text("Nombre completo") },
            leadingIcon     = { Icon(Icons.Default.Person, null) },
            isError         = nombre.isNotEmpty() && !nombreValido,
            supportingText  = {
                when {
                    nombre.isNotEmpty() && !nombreValido ->
                        Text("Mínimo 3 caracteres", color = MaterialTheme.colorScheme.error)
                    nombreValido ->
                        Text("✓ Nombre válido", color = MaterialTheme.colorScheme.primary)
                    else -> Text("Requerido")
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value           = cedula,
            onValueChange   = { cedula = it },
            label           = { Text("Cédula de identidad") },
            placeholder     = { Text("10 dígitos") },
            leadingIcon     = { Icon(Icons.Default.Badge, null) },
            isError         = cedula.isNotEmpty() && !cedulaValida,
            supportingText  = {
                if (cedula.isNotEmpty() && !cedulaValida)
                    Text("Debe tener exactamente 10 dígitos",
                        color = MaterialTheme.colorScheme.error)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value           = email,
            onValueChange   = { email = it },
            label           = { Text("Correo electrónico") },
            placeholder     = { Text("paciente@correo.com") },
            leadingIcon     = { Icon(Icons.Default.Email, null) },
            isError         = email.isNotEmpty() && !emailValido,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value           = telefono,
            onValueChange   = { telefono = it },
            label           = { Text("Teléfono") },
            placeholder     = { Text("+593 99 999 9999") },
            leadingIcon     = { Icon(Icons.Default.Phone, null) },
            isError         = telefono.isNotEmpty() && !telValido,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value           = motivo,
            onValueChange   = { motivo = it },
            label           = { Text("Motivo de consulta") },
            placeholder     = { Text("Describe brevemente tus síntomas...") },
            leadingIcon     = { Icon(Icons.Default.MedicalServices, null) },
            isError         = motivo.isNotEmpty() && !motivoValido,
            supportingText  = {
                Text("${motivo.length} caracteres (mín. 5)",
                    color = if (motivoValido) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onSurfaceVariant)
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            singleLine      = false,
            modifier        = Modifier.fillMaxWidth()
        )

        Button(
            onClick  = {},
            enabled  = formValido,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (formValido) "Registrar paciente ✓" else "Completa todos los campos")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01_TextField_Preview_mp() {
    MaterialTheme { Paso01_TextField_mp() }
}
