// lib/router/app_router_paso4_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../screens/scaffold_con_nav_mp.dart';
import '../screens/pantalla_citas_mp.dart';
import '../screens/pantalla_detalle_cita_mp.dart';
import '../screens/pantalla_estadisticas_mp.dart';
import '../screens/pantalla_ajustes_mp.dart';
import '../models/cita_mp.dart';

final appRouterPaso4Mp = GoRouter(
  initialLocation: '/citas',
  debugLogDiagnostics: true,
  routes: [
    // ShellRoute — mantiene ScaffoldConNavMp vivo entre rutas hijas
    ShellRoute(
      builder: (context, state, child) => ScaffoldConNavMp(child: child),
      routes: [
        GoRoute(
          path:    '/citas',
          builder: (_, __) => const PantallaCitasMp(),
          routes: [
            GoRoute(
              path:    ':id',
              builder: (context, state) {
                final id   = state.pathParameters['id']!;
                final cita = state.extra as Cita?;
                return PantallaDetalleCitaMp(id: id, cita: cita);
              },
            ),
          ],
        ),
        GoRoute(
          path:    '/estadisticas',
          builder: (_, __) => const PantallaEstadisticasMp(),
        ),
        GoRoute(
          path:    '/ajustes',
          builder: (_, __) => const PantallaAjustesMp(),
        ),
      ],
    ),
  ],
);
