// ui/Paso01_TextField.kt
package com.example.compose.material

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Paso01AreaScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Paso 1 · TextField y OutlinedTextField",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        MultiplicacionNumeros()
    }
}

// ── Suma de dos numeros ───────────────────────────────
@Composable
private fun MultiplicacionNumeros() {
    var base1     by remember { mutableStateOf("") }
    var alutura2      by remember { mutableStateOf("") }
    var resultado   by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Formulario nuevo contacto",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        // Nombre — validación básica de longitud
        OutlinedTextField(
            value           = base1,
            onValueChange   = { base1 = it },
            label           = { Text("Primer valor") },
            leadingIcon     = { Icon(Icons.Default.Person, contentDescription = null) },
            // keyboardOptions configura el teclado del sistema operativo
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        // Nombre — validación básica de longitud
        OutlinedTextField(
            value           = alutura2,
            onValueChange   = { alutura2 = it },
            label           = { Text("Segundo valor") },
            leadingIcon     = { Icon(Icons.Default.Person, contentDescription = null) },
            // keyboardOptions configura el teclado del sistema operativo
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )


        Button(
            onClick  = {
                val base1Double = base1.toDoubleOrNull()?:0.0
                val alutura2Double = alutura2.toDoubleOrNull()?:0.0
                resultado = (base1Double*alutura2Double/2).toString()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text( text = "Multiplicar")
        }
        Text( text = "Resultado de $base1 * $alutura2 = $resultado")
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01AreaPreview() {
    MaterialTheme { Paso01AreaScreen() }
}