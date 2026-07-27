// lib/main.dart
import 'package:flutter/material.dart';
import 'screens/paso1_conexion_manual_mp.dart';
import 'screens/paso2_formulario_validado_mp.dart';
import 'screens/paso3_lista_citas_mp.dart';
import 'screens/pantalla_citas_mp.dart';
import 'screens/pantalla_busqueda_citas_mp.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  TextField + TextEditingController + FocusNode       │
// │  2  Paso 2  Form + TextFormField + validación                   │
// │  3  Paso 3  Modelo + ListView.builder + ListTile acciones       │
// │  4  Paso 4  GridView.builder + toggle lista/grid                │
// │  5  Paso 5  SearchBar + filtrado en tiempo real                 │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 5;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  theme: ThemeData(
    colorScheme: ColorScheme.fromSeed(
      seedColor: const Color(0xFF1B5E20),
    ),
    useMaterial3: true,
  ),
  home: switch (paso) {
    1 => const Paso1ConexionManualMp(),
    2 => const Paso2FormularioValidadoMp(),
    3 => const Paso3ListaCitasMp(),
    4 => const PantallaCitasMp(),
    5 => const PantallaBusquedaCitasMp(),
    _ => Scaffold(
        body: Center(child: Text('Paso $paso: crea el widget primero'))),
  },
));
