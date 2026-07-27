// lib/router/app_router_paso2_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../screens/pantalla_inicio_mp.dart';
import '../screens/pantalla_citas_mp.dart';
import '../screens/pantalla_detalle_cita_mp.dart';
import '../models/cita_mp.dart';

final appRouterPaso2Mp = GoRouter(
  initialLocation: '/',
  debugLogDiagnostics: true,
  routes: [
    GoRoute(
      path:    '/',
      builder: (context, state) => const PantallaInicioMp(),
    ),
    GoRoute(
      path:    '/citas',
      builder: (context, state) => const PantallaCitasMp(),
      routes: [
        // Ruta hija: /citas/:id
        GoRoute(
          path:    ':id',   // relativa — ruta completa: /citas/:id
          builder: (context, state) {
            final id   = state.pathParameters['id']!;
            final cita = state.extra as Cita?;
            return PantallaDetalleCitaMp(id: id, cita: cita);
          },
        ),
        // Ruta hija: /citas/:id/notas
        GoRoute(
          path:    ':id/notas',
          builder: (context, state) {
            final id = state.pathParameters['id']!;
            return Scaffold(
              appBar: AppBar(title: Text('Notas de $id')),
              body:   Center(child: Text('Notas del turno $id')),
            );
          },
        ),
      ],
    ),
  ],
);
