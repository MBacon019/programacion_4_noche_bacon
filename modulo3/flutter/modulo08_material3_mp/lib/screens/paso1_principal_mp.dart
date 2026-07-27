// lib/screens/paso1_principal_mp.dart
// Paso 1 — AppBar, FAB y layout básico con Material 3 (extraído del router)
import 'package:flutter/material.dart';

class PantallaPrincipalMedica extends StatelessWidget {
  const PantallaPrincipalMedica({super.key});

  @override
  Widget build(BuildContext context) {
    final cs   = Theme.of(context).colorScheme;
    final text = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Consultas Médicas'),
        centerTitle: true,
        backgroundColor: cs.tertiaryContainer,
        foregroundColor: cs.onPrimaryContainer,
        actions: [
          IconButton(icon: const Icon(Icons.refresh), onPressed: () {}),
        ],
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(Icons.local_hospital, size: 96, color: cs.primary),
            const SizedBox(height: 16),
            Text(
              'Dr. Herrera — Cardiología',
              style: text.headlineMedium?.copyWith(fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),
            Text(
              'Consultorio 3 · Turno 09:00 - 13:00',
              style: text.bodyMedium?.copyWith(color: cs.onSurfaceVariant),
            ),
            const SizedBox(height: 24),
            FilledButton.icon(
              onPressed: () {},
              icon:  const Icon(Icons.medical_services),
              label: const Text('Iniciar consulta'),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        tooltip: 'Agregar paciente',
        child:   const Icon(Icons.add),
      ),
    );
  }
}
