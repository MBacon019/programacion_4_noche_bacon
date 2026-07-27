// Paso01Suma_mp.kt — Calculadora de costo de consulta
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Paso01Suma_mp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Paso01 · Suma — Costo de Consulta Médica",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        CostoConsulta()
    }
}

@Composable
private fun CostoConsulta() {
    var costoConsulta   by remember { mutableStateOf("") }
    var costoExamenes   by remember { mutableStateOf("") }
    var total           by remember { mutableStateOf("") }
    var totalConSeguro  by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Liquidación de consulta",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        OutlinedTextField(
            value           = costoConsulta,
            onValueChange   = { costoConsulta = it },
            label           = { Text("Costo de la consulta (\$)") },
            leadingIcon     = { Icon(Icons.Default.LocalHospital, null) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value           = costoExamenes,
            onValueChange   = { costoExamenes = it },
            label           = { Text("Costo de exámenes (\$)") },
            leadingIcon     = { Icon(Icons.Default.Science, null) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Done),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val c1    = costoConsulta.toDoubleOrNull() ?: 0.0
                val c2    = costoExamenes.toDoubleOrNull() ?: 0.0
                val t     = c1 + c2
                val seg   = t * 0.80  // el seguro cubre el 80%
                total          = "%.2f".format(t)
                totalConSeguro = "%.2f".format(t - seg)
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Calcular total") }

        if (total.isNotEmpty()) {
            HorizontalDivider()
            Text("Subtotal:          \$$total",
                style = MaterialTheme.typography.bodyLarge)
            val descuentoSeguro = "%.2f".format(total.toDouble() * 0.80)
            Text("Seguro cubre 80%: -\$$descuentoSeguro",
                color = MaterialTheme.colorScheme.primary)
            Text("A pagar por paciente: \$$totalConSeguro",
                style      = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color      = MaterialTheme.colorScheme.error)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01Suma_Preview_mp() {
    MaterialTheme { Paso01Suma_mp() }
}
