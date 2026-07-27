// lib/main.dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

// Importa las pantallas a medida que las crees en cada paso:
import 'screens/paso1_contador_citas_mp.dart';
import 'screens/pantalla_citas_mp.dart';
import 'screens/pantalla_busqueda_citas_mp.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  StateProvider básico (contador)                     │
// │  2  Paso 2  NotifierProvider + lista de turnos                  │
// │  3  Paso 3  Provider derivado + búsqueda filtrada                │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 3;

void main() {
  runApp(const ProviderScope(child: AppTurnos()));
}

class AppTurnos extends StatelessWidget {
  const AppTurnos({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: const Color(0xFF0D47A1)),
        useMaterial3: true,
      ),
      home: switch (paso) {
        1 => const Paso1ContadorCitasMp(),
        2 => const PantallaCitasMp(),
        3 => const PantallaBusquedaCitasMp(),
        _ => Scaffold(
            body: Center(child: Text('Paso $paso: crea el widget primero'))),
      },
    );
  }
}
