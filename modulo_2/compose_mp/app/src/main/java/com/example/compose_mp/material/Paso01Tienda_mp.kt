// Paso01Tienda_mp.kt — Calculadora de farmacia (medicamentos)
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
fun Paso01Tienda_mp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Paso01 · Farmacia — Calculadora de Medicamentos",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        CalculadoraFarmacia()
    }
}

@Composable
private fun CalculadoraFarmacia() {
    var medicamento by remember { mutableStateOf("") }
    var precio      by remember { mutableStateOf("") }
    var cantidad    by remember { mutableStateOf("") }
    var subtotal    by remember { mutableStateOf("") }
    var descuento   by remember { mutableStateOf("") }
    var total       by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Despacho de farmacia",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        OutlinedTextField(
            value           = medicamento,
            onValueChange   = { medicamento = it },
            label           = { Text("Nombre del medicamento") },
            leadingIcon     = { Icon(Icons.Default.Medication, null) },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value           = precio,
            onValueChange   = { precio = it },
            label           = { Text("Precio unitario (\$)") },
            leadingIcon     = { Icon(Icons.Default.AttachMoney, null) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value           = cantidad,
            onValueChange   = { cantidad = it },
            label           = { Text("Cantidad (unidades)") },
            leadingIcon     = { Icon(Icons.Default.Numbers, null) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val p   = precio.toDoubleOrNull()   ?: 0.0
                val c   = cantidad.toDoubleOrNull()  ?: 0.0
                val sub = p * c
                // Descuento: 10% si supera $50, 5% si supera $20
                val pct = when {
                    sub > 50.0 -> 0.10
                    sub > 20.0 -> 0.05
                    else       -> 0.0
                }
                val desc  = sub * pct
                val tot   = sub - desc
                subtotal  = "%.2f".format(sub)
                descuento = "%.2f".format(desc)
                total     = "%.2f".format(tot)
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Calcular") }

        if (total.isNotEmpty()) {
            HorizontalDivider()
            Text("Medicamento: $medicamento")
            Text("Subtotal:    \$$subtotal")
            Text("Descuento:  -\$$descuento",  color = MaterialTheme.colorScheme.primary)
            Text("Total:       \$$total",
                fontWeight = FontWeight.Bold,
                style      = MaterialTheme.typography.titleMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01Tienda_Preview_mp() {
    MaterialTheme { Paso01Tienda_mp() }
}
