// lib/screens/pantalla_citas_mp.dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../models/cita_mp.dart';
import '../providers/citas_provider_mp.dart';

// ─── Paso 2 — NotifierProvider + lista de turnos ────────────────────────
class PantallaCitasMp extends ConsumerWidget {
  const PantallaCitasMp({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final citas = ref.watch(citasProvider);
    final cs    = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Turnos (${citas.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: citas.isEmpty
          ? const Center(child: Text('Sin turnos'))
          : ListView.separated(
              itemCount:        citas.length,
              separatorBuilder: (_, __) =>
                  const Divider(height: 1, indent: 72),
              itemBuilder: (context, i) {
                final c = citas[i];
                return ListTile(
                  leading: CircleAvatar(
                    backgroundColor: c.urgente
                        ? Colors.red.shade50
                        : Colors.grey.shade100,
                    child: Icon(Icons.event_note,
                        color: c.urgente ? Colors.red : Colors.grey),
                  ),
                  title:    Text(c.paciente,
                      style: const TextStyle(fontWeight: FontWeight.w600)),
                  subtitle: Text('${c.fecha} · ${c.hora}'),
                  trailing: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      IconButton(
                        icon: Icon(
                          c.confirmada ? Icons.check_circle : Icons.check_circle_outline,
                          color: c.confirmada ? Colors.green : null,
                        ),
                        onPressed: () => ref
                            .read(citasProvider.notifier)
                            .toggleConfirmada(c.id),
                      ),
                      IconButton(
                        icon: const Icon(Icons.delete_outline,
                            color: Colors.red),
                        onPressed: () => ref
                            .read(citasProvider.notifier)
                            .eliminar(c.id),
                      ),
                    ],
                  ),
                );
              },
            ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          final id = DateTime.now().millisecondsSinceEpoch.toString();
          ref.read(citasProvider.notifier).agregar(
            Cita(
              id:       id,
              paciente: 'Nuevo paciente $id',
              fecha:    '29/07/2026',
              hora:     '12:00',
              urgente:  true,
            ),
          );
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}
