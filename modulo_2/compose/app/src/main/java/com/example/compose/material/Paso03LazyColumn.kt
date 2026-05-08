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
fun Paso01tiendaScreen() {
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
        Calculonumero()
    }
}

// ── Suma de dos numeros ───────────────────────────────
@Composable
private fun Calculonumero() {
    var cantidad     by remember { mutableStateOf("") }
    var precio      by remember { mutableStateOf("") }
    var producto   by remember { mutableStateOf("") }
    var subtotal   by remember { mutableStateOf("") }
    var descuento   by remember { mutableStateOf("") }
    var total   by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Formulario nuevo contacto",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        // Nombre — validación básica de longitud
        OutlinedTextField(
            value           = precio,
            onValueChange   = { precio = it },
            label           = { Text("Precio") },
            leadingIcon     = { Icon(Icons.Default.Person, contentDescription = null) },
            // keyboardOptions configura el teclado del sistema operativo
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        // Nombre — validación básica de longitud
        OutlinedTextField(
            value           = cantidad,
            onValueChange   = { cantidad = it },
            label           = { Text("Cantidad") },
            leadingIcon     = { Icon(Icons.Default.Person, contentDescription = null) },
            // keyboardOptions configura el teclado del sistema operativo
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )
        // Nombre — validación básica de longitud
        OutlinedTextField(
            value           = producto,
            onValueChange   = { producto = it },
            label           = { Text("Producto") },
            leadingIcon     = { Icon(Icons.Default.Person, contentDescription = null) },
            // keyboardOptions configura el teclado del sistema operativo
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )


        Button(
            onClick  = {

                val precioDouble = precio.toDoubleOrNull()?:0.0
                val cantidadDouble = cantidad.toDoubleOrNull()?:0.0
                val subtotalDouble = precioDouble*cantidadDouble
                var porcentaje = 0.0
                if (subtotalDouble > 50.0) {
                    porcentaje = 0.10
                } else if (subtotalDouble > 50.0){
                    porcentaje = 0.05
                }
                val descuentoDouble= subtotalDouble*porcentaje
                val totalDouble = subtotalDouble-descuentoDouble
                subtotal=subtotalDouble.toString()
                descuento=descuentoDouble.toString()
                total=totalDouble.toString()

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text( text = "Calcular")
        }
        Text( text = "Producto $producto")
        Text( text = "Subtotal $subtotal")
        Text( text = "Descuento $descuento")
        Text( text = "Total a pagar $total")
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01tiendaPreview() {
    MaterialTheme { Paso01tiendaScreen() }
}