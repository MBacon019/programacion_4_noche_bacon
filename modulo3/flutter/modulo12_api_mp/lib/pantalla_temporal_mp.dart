import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

// ── Pantalla temporal: muestra "próximamente" hasta que crees la pantalla real ─
class PantallaTemporalMp extends StatelessWidget {
  final String titulo;
  const PantallaTemporalMp({required this.titulo, super.key});

  @override
  Widget build(BuildContext context) => Scaffold(
    appBar: AppBar(title: Text(titulo)),
    body: Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const Icon(Icons.hourglass_empty, size: 64, color: Colors.grey),
          const SizedBox(height: 16),
          Text(
            '$titulo\nPróximamente…',
            textAlign: TextAlign.center,
            style: const TextStyle(fontSize: 20, color: Colors.grey),
          ),
          const SizedBox(height: 32),
          ElevatedButton.icon(
            icon: const Icon(Icons.arrow_back),
            label: const Text('Volver al menú'),
            onPressed: () => context.go('/'),
          ),
        ],
      ),
    ),
  );
}
