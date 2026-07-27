// lib/screens/pantalla_citas_filtro_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../models/cita_mp.dart';

class PantallaCitasFiltroMp extends StatelessWidget {
  final bool soloUrgentes;
  const PantallaCitasFiltroMp({super.key, this.soloUrgentes = false});

  @override
  Widget build(BuildContext context) {
    final filtradas = soloUrgentes
        ? citasSimuladas.where((c) => c.urgente).toList()
        : citasSimuladas;

    return Scaffold(
      appBar: AppBar(
        title:   Text('Turnos${soloUrgentes ? ' (urgentes)' : ''}'),
        actions: [
          // Toggle filtro urgentes — cambia la URL con query param
          IconButton(
            icon:    Icon(soloUrgentes ? Icons.priority_high : Icons.filter_list_off),
            tooltip: soloUrgentes ? 'Ver todos' : 'Solo urgentes',
            onPressed: () => soloUrgentes
                ? context.go('/citas')
                : context.go('/citas?soloUrgentes=true'),
          ),
        ],
      ),
      body: ListView.builder(
        itemCount:   filtradas.length,
        itemBuilder: (context, i) {
          final c = filtradas[i];
          return ListTile(
            leading: Icon(Icons.event_note, color: c.urgente ? Colors.red : Colors.grey),
            title:   Text(c.paciente),
            subtitle: Text('${c.fecha} · ${c.hora}'),
            onTap: () => context.push(
              '/citas/${c.id}',
              extra: c,   // pasa el objeto completo
            ),
          );
        },
      ),
    );
  }
}
