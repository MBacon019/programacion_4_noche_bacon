// MainActivity.kt
package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.compose.screens.*
import com.example.compose.material.*
import com.example.compose.ui.viewmodel.Paso01_ViewModelScreen
import com.example.compose.ui.Paso02_UiStateScreen

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // ══════════════════════════════════════════════════
                // GRUPO 1 · Composable básico (8 pantallas)
                // ══════════════════════════════════════════════════
                // S01_SaludoScreen()        // S01 · @Composable básico
                // S02TextScreen()           // S02 · Text con estilos
                // S03_ButtonScreen()        // S03 · Variantes de Button
                // S04_LayoutScreen()        // S04 · Column / Row / Box
                // S05ModifierScreen()       // S05 · Modifier
                // S06EstadoScreen()         // S06 · Estado y recomposición
                // S07_StateHoistingScreen() // S07 · State Hoisting
                // S08_BienvenidaScreen()    // S08 · Onboarding 3 pasos

                // ══════════════════════════════════════════════════
                // GRUPO 2 · Material 3 (9 pantallas)
                // ══════════════════════════════════════════════════
                // Paso01_TextFieldScreen()  // Paso01 · TextField + formulario con validación
                // Paso01SumaScreen()        // Paso01 · Suma de dos números
                // Paso01tienda()            // Paso01 · Calculadora precio/cantidad/descuento
                // Paso01AreaScreen()        // Paso01 · Cálculo de áreas
                // Paso02_CardScreen()       // Paso02 · Card y ElevatedCard
                // Paso04ScaffoldScreen()    // Paso04 · Scaffold + TopAppBar + FAB
                // Paso05NavBarScreen()      // Paso05 · NavigationBar (agenda)
                Paso06DialogosScreen()       // Paso06 · Diálogos + AlertDialog + Snackbar ← ACTIVO

                // ══════════════════════════════════════════════════
                // GRUPO 3 · ViewModel + StateFlow (2 pantallas)
                // ══════════════════════════════════════════════════
                // Paso01_ViewModelScreen()  // ViewModel · StateFlow + búsqueda reactiva
                // Paso02_UiStateScreen()    // ViewModel · sealed class UiState (Loading/Error/Success)
            }
        }
    }
}
