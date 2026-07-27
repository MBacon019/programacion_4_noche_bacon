// lib/screens/pantalla_detalle_cita_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../models/cita_mp.dart';

class PantallaDetalleCitaMp extends StatelessWidget {
  final String id;
  final Cita?  cita; // puede venir por extras

  const PantallaDetalleCitaMp({super.key, required this.id, this.cita});

  @override
  Widget build(BuildContext context) {
    // Si no viene por extras, buscar en la lista simulada
    final c = cita ??
        citasSimuladas.where((x) => x.id == id).firstOrNull;

    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Detalle: ${c?.paciente ?? id}'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: c == null
          ? Center(child: Text('Turno $id no encontrado'))
          : Padding(
              padding: const EdgeInsets.all(16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  _Fila('ID',       c.id),
                  _Fila('Paciente', c.paciente),
                  _Fila('Fecha',    c.fecha),
                  _Fila('Hora',     c.hora),
                  _Fila('Urgente',  c.urgente ? 'Sí' : 'No'),
                  const SizedBox(height: 24),
                  Row(children: [
                    OutlinedButton.icon(
                      onPressed: () => context.pop(),
                      icon:  const Icon(Icons.arrow_back),
                      label: const Text('Volver'),
                    ),
                    const SizedBox(width: 12),
                    FilledButton.icon(
                      onPressed: () => context.push('/citas/${c.id}/notas'),
                      icon:  const Icon(Icons.list_alt),
                      label: const Text('Ver notas'),
                    ),
                  ]),
                ],
              ),
            ),
    );
  }
}

class _Fila extends StatelessWidget {
  final String label;
  final String valor;
  const _Fila(this.label, this.valor);

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 6),
      child: Row(children: [
        SizedBox(
          width: 70,
          child: Text(label,
              style: TextStyle(color: cs.onSurfaceVariant,
                  fontWeight: FontWeight.w600, fontSize: 12)),
        ),
        Text(valor, style: const TextStyle(fontSize: 15)),
      ]),
    );
  }
}
