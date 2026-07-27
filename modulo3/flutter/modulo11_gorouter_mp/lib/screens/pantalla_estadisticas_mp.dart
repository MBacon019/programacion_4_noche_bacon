// lib/screens/pantalla_estadisticas_mp.dart
import 'package:flutter/material.dart';

class PantallaEstadisticasMp extends StatelessWidget {
  const PantallaEstadisticasMp({super.key});

  @override
  Widget build(BuildContext context) => Scaffold(
    body: const Center(child: Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        Icon(Icons.bar_chart, size: 56),
        SizedBox(height: 8),
        Text('Estadísticas de turnos', style: TextStyle(fontSize: 18)),
      ],
    )),
  );
}
