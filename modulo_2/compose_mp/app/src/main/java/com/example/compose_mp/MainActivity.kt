// MainActivity.kt — Consultas Médicas MP
package com.example.compose_mp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.compose_mp.screens.*
import com.example.compose_mp.material.*
import com.example.compose_mp.viewmodel.Paso01_ViewModel_mp
import com.example.compose_mp.viewmodel.Paso02_UiState_mp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // ══════════════════════════════════════════════════════
                // GRUPO 1 · Composable básico — 8 pantallas
                // ══════════════════════════════════════════════════════
                // S01_Saludo_mp()           // S01 · @Composable básico
                // S02Text_mp()              // S02 · Text con estilos médicos
                // S03_Button_mp()           // S03 · Botones: Agendar, Urgente, Historial
                // S04_Layout_mp()           // S04 · Column / Row / Box (ficha, cita, urgencias)
                // S05Modifier_mp()          // S05 · Modifier (badge urgencia, avatares especialidad)
                // S06Estado_mp()            // S06 · Contador sala espera + ocupación hospital
                // S07_StateHoisting_mp()    // S07 · Selector especialidad → médico disponible
                // S08_Bienvenida_mp()       // S08 · Onboarding: especialidad → turno → confirmación

                // ══════════════════════════════════════════════════════
                // GRUPO 2 · Material 3 — 8 pantallas
                // ══════════════════════════════════════════════════════
                // Paso01_TextField_mp()     // Paso01 · Registro paciente con validación
                // Paso01Suma_mp()           // Paso01 · Costo consulta + exámenes con seguro
                // Paso01Tienda_mp()         // Paso01 · Farmacia: medicamento × cantidad
                // Paso01Area_mp()           // Paso01 · Calculadora IMC (peso + talla)
                // Paso02_Card_mp()          // Paso02 · Tarjetas de consulta con estado
                // Paso04Scaffold_mp()       // Paso04 · Scaffold + lista consultas + filtros
                // Paso05NavBar_mp()         // Paso05 · NavBar: Consultas / Médicos / Perfil
                // Paso06Dialogos_mp()          // Paso06 · Agenda completa: diálogos + snackbar ← ACTIVO

                // ══════════════════════════════════════════════════════
                // GRUPO 3 · ViewModel + StateFlow — 2 pantallas
                // ══════════════════════════════════════════════════════
                // Paso01_ViewModel_mp()     // ViewModel · Lista con búsqueda reactiva
                // Paso02_UiState_mp()       // ViewModel · Loading / Error / Success
            }
        }
    }
}
