// lib/screens/pantalla_inicio_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class PantallaInicioMp extends StatelessWidget {
  const PantallaInicioMp({super.key});

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Gestor de Turnos'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(Icons.medical_services, size: 64, color: cs.primary),
            const SizedBox(height: 16),
            const Text('Consultorio Médico',
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
            const SizedBox(height: 8),
            Text('Gestiona los turnos de tus pacientes',
                style: TextStyle(color: cs.onSurfaceVariant)),
            const SizedBox(height: 32),
            FilledButton.icon(
              // context.go() — navega SIN apilar (no hay botón "atrás")
              onPressed: () => context.go('/citas'),
              icon:  const Icon(Icons.event_note),
              label: const Text('Ver turnos'),
            ),
          ],
        ),
      ),
    );
  }
}
