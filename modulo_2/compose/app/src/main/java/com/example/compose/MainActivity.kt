// MainActivity.kt
package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.compose.screens.*
import com.example.compose.material.*
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // ◀ CAMBIA AQUÍ para probar cada sección:
                //S01SaludoScreen()
                // S02TextScreen()
                // S03ButtonScreen()
                 //S04LayoutScreen()
                 //S05ModifierScreen()
                 //S06EstadoScreen()
                 //S07StateHoistingScreen()
                 //S08BienvenidaScreen()

                //Componentes Material 3: TextField, Card, LazyColumn, Scaffold y diálogos
                // ◀ CAMBIA AQUÍ para probar cada paso:
                // Paso01TextFieldScreen()
                // Paso01SumaScreen()
                // Paso01tienda()
                // Paso01AreaScreen()
                // Paso02CardScreen()
                // Paso03LazyColumnScreen()
                // Paso04ScaffoldScreen()
                // Paso05NavBarScreen()
                //  Paso06DialogosScreen()   // ← paso activo
            }
        }
    }
}