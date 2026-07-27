// lib/router/app_router_paso3_mp.dart
import 'package:go_router/go_router.dart';
import '../screens/pantalla_inicio_mp.dart';
import '../screens/pantalla_citas_filtro_mp.dart';
import '../screens/pantalla_detalle_cita_mp.dart';
import '../models/cita_mp.dart';

final appRouterPaso3Mp = GoRouter(
  initialLocation: '/',
  routes: [
    GoRoute(
      path:    '/',
      builder: (context, state) => const PantallaInicioMp(),
    ),
    GoRoute(
      path:    '/citas',
      builder: (context, state) {
        // Query parameters — /citas?soloUrgentes=true
        final soloUrgentes = state.uri.queryParameters['soloUrgentes'] == 'true';
        return PantallaCitasFiltroMp(soloUrgentes: soloUrgentes);
      },
    ),
    GoRoute(
      path:    '/citas/:id',
      builder: (context, state) {
        final id   = state.pathParameters['id']!;
        final cita = state.extra as Cita?;
        return PantallaDetalleCitaMp(id: id, cita: cita);
      },
    ),
  ],
);
