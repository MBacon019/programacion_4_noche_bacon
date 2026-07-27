import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'router/app_router_mp.dart';
import 'router/app_router_paso2_mp.dart';
import 'router/app_router_paso3_mp.dart';
import 'router/app_router_paso4_mp.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  Rutas básicas + context.go / push / pop             │
// │  2  Paso 2  pathParameters + pantalla de detalle                │
// │  3  Paso 3  queryParameters + extras                            │
// │  4  Paso 4  ShellRoute completo + NavigationBar persistente     │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 4;

void main() {
  runApp(
    ProviderScope(
      child: AppTurnos(paso: paso),
    ),
  );
}

class AppTurnos extends StatelessWidget {
  final int paso;
  const AppTurnos({super.key, required this.paso});

  @override
  Widget build(BuildContext context) {
    final router = switch (paso) {
      1 => appRouterMp,
      2 => appRouterPaso2Mp,
      3 => appRouterPaso3Mp,
      4 => appRouterPaso4Mp,
      int() => throw UnimplementedError(),
    };

    return MaterialApp.router(
      title:        'Gestor de Turnos',
      debugShowCheckedModeBanner: false,
      routerConfig: router,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: const Color(0xFF0D47A1)),
        useMaterial3: true,
      ),
    );
  }
}
