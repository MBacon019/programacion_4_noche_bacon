import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';

import 'pantalla_menu_mp.dart';
import 'pantalla_temporal_mp.dart';
import 'pantalla_paso1_mp.dart';
import 'pantalla_paso2_mp.dart';
import 'pantalla_paso3_mp.dart';

// ── Router — actualiza cada builder cuando crees la pantalla del paso ─────────
final _router = GoRouter(
  initialLocation: '/',
  routes: [
    GoRoute(path: '/', builder: (_, __) => const PantallaMenuMp()),

    // Paso 1 → FutureBuilder crudo
    GoRoute(path: '/paso1', builder: (_, __) => const PantallaPaso1Mp()),

    // Paso 2 → DTO simple
    GoRoute(path: '/paso2', builder: (_, __) => const PantallaPaso2Mp()),

    // Paso 3 → API real + modelo de dominio
    GoRoute(path: '/paso3', builder: (_, __) => const PantallaPaso3Mp()),

    // Paso 4 → reemplaza por PantallaPaso4Mp()
    GoRoute(path: '/paso4', builder: (_, __) => const PantallaTemporalMp(titulo: 'Paso 4 · Errores tipados')),

    // Paso 5 → reemplaza por PantallaPaso5Mp()
    GoRoute(path: '/paso5', builder: (_, __) => const PantallaTemporalMp(titulo: 'Paso 5 · Arquitectura completa')),
  ],
);

void main() => runApp(const ProviderScope(child: AppConsultorio()));

class AppConsultorio extends StatelessWidget {
  const AppConsultorio({super.key});

  @override
  Widget build(BuildContext context) => MaterialApp.router(
    debugShowCheckedModeBanner: false,
    routerConfig: _router,
    theme: ThemeData(
      colorScheme: ColorScheme.fromSeed(seedColor: Colors.indigo),
      useMaterial3: true,
    ),
  );
}
