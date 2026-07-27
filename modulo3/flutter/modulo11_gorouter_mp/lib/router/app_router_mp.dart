// lib/router/app_router_mp.dart
import 'package:go_router/go_router.dart';
import '../screens/pantalla_inicio_mp.dart';
import '../screens/pantalla_citas_mp.dart';

final appRouterMp = GoRouter(
  initialLocation: '/',
  debugLogDiagnostics: true,  // imprime cada navegación en la consola
  routes: [
    GoRoute(
      path:    '/',
      name:    'inicio',
      builder: (context, state) => const PantallaInicioMp(),
    ),
    GoRoute(
      path:    '/citas',
      name:    'citas',
      builder: (context, state) => const PantallaCitasMp(),
    ),
  ],
);
