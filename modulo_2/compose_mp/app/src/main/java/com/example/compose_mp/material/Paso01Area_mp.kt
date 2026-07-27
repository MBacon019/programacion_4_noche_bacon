// Paso01Area_mp.kt — Calculadora de IMC (Índice de Masa Corporal)
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
fun Paso01Area_mp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Paso01 · Área — Calculadora de IMC",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        CalculadoraIMC()
    }
}

@Composable
private fun CalculadoraIMC() {
    var peso       by remember { mutableStateOf("") }
    var talla      by remember { mutableStateOf("") }
    var imc        by remember { mutableStateOf("") }
    var categoria  by remember { mutableStateOf("") }
    var riesgo     by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Índice de Masa Corporal (IMC)",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        Text("Fórmula: IMC = peso(kg) ÷ talla²(m)",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant)

        OutlinedTextField(
            value           = peso,
            onValueChange   = { peso = it },
            label           = { Text("Peso (kg)") },
            leadingIcon     = { Icon(Icons.Default.MonitorWeight, null) },
            placeholder     = { Text("ej: 70.5") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value           = talla,
            onValueChange   = { talla = it },
            label           = { Text("Talla (m)") },
            leadingIcon     = { Icon(Icons.Default.Height, null) },
            placeholder     = { Text("ej: 1.75") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Done),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val p = peso.toDoubleOrNull()  ?: 0.0
                val t = talla.toDoubleOrNull() ?: 0.0
                if (t > 0) {
                    val imcVal = p / (t * t)
                    imc = "%.2f".format(imcVal)
                    categoria = when {
                        imcVal < 18.5 -> "Bajo peso"
                        imcVal < 25.0 -> "Peso normal"
                        imcVal < 30.0 -> "Sobrepeso"
                        imcVal < 35.0 -> "Obesidad grado I"
                        imcVal < 40.0 -> "Obesidad grado II"
                        else          -> "Obesidad grado III"
                    }
                    riesgo = when {
                        imcVal < 18.5 -> "Riesgo de desnutrición"
                        imcVal < 25.0 -> "Sin riesgo cardiovascular"
                        imcVal < 30.0 -> "Riesgo cardiovascular leve"
                        imcVal < 35.0 -> "Riesgo cardiovascular moderado"
                        else          -> "Riesgo cardiovascular alto"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Calcular IMC") }

        if (imc.isNotEmpty()) {
            HorizontalDivider()
            Text("IMC:      $imc",
                style      = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color      = MaterialTheme.colorScheme.primary)
            Text("Categoría: $categoria", style = MaterialTheme.typography.titleMedium)
            Text("Riesgo:    $riesgo",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01Area_Preview_mp() {
    MaterialTheme { Paso01Area_mp() }
}
