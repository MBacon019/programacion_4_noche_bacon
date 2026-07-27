// lib/screens/scaffold_con_nav_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class ScaffoldConNavMp extends StatelessWidget {
  final Widget child;
  const ScaffoldConNavMp({super.key, required this.child});

  // Detecta la ruta activa para resaltar la tab correcta
  int _indiceActivo(BuildContext context) {
    final loc = GoRouterState.of(context).uri.path;
    if (loc.startsWith('/estadisticas')) return 1;
    if (loc.startsWith('/ajustes'))      return 2;
    return 0; // /citas
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: child,    // child cambia, el Scaffold NO se reconstruye
      bottomNavigationBar: NavigationBar(
        selectedIndex:         _indiceActivo(context),
        onDestinationSelected: (i) {
          switch (i) {
            case 0: context.go('/citas');
            case 1: context.go('/estadisticas');
            case 2: context.go('/ajustes');
          }
        },
        destinations: const [
          NavigationDestination(
            icon: Icon(Icons.event_note_outlined), selectedIcon: Icon(Icons.event_note),
            label: 'Turnos',
          ),
          NavigationDestination(
            icon: Icon(Icons.bar_chart_outlined), selectedIcon: Icon(Icons.bar_chart),
            label: 'Estadísticas',
          ),
          NavigationDestination(
            icon: Icon(Icons.settings_outlined), selectedIcon: Icon(Icons.settings),
            label: 'Ajustes',
          ),
        ],
      ),
    );
  }
}
