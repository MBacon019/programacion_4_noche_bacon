// lib/screens/pantalla_citas_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../models/cita_mp.dart';

class PantallaCitasMp extends StatelessWidget {
  const PantallaCitasMp({super.key});

  @override
  Widget build(BuildContext context) {
    final cs    = Theme.of(context).colorScheme;
    final citas = citasSimuladas;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Turnos'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: ListView.builder(
        itemCount:   citas.length,
        itemBuilder: (context, i) {
          final cita = citas[i];
          return ListTile(
            leading: const Icon(Icons.event_note),
            title:   Text(cita.paciente),
            onTap: () {
              // context.push() — apila la pantalla (aparece botón "atrás")
              context.push(
                '/citas/${cita.id}',
                extra: cita,
              );
            },
          );
        },
      ),
    );
  }
}
