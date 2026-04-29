// MainActivity.kt
package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.compose.screens.S01_SaludoScreen

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // ◀ CAMBIA AQUÍ para probar cada sección:
                S01_SaludoScreen()
                // S02_TextScreen()
                // S03_ButtonScreen()
                // S04_LayoutScreen()
                // S05_ModifierScreen()
                // S06_EstadoScreen()
                // S07_StateHoistingScreen()
                // S08_BienvenidaScreen()
            }
        }
    }
}