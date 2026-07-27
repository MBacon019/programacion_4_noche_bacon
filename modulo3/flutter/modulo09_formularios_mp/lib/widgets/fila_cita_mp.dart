// lib/widgets/fila_cita_mp.dart
import 'package:flutter/material.dart';
import '../models/cita_mp.dart';

class FilaCitaMp extends StatelessWidget {
  final Cita         cita;
  final VoidCallback onConfirmar;
  final VoidCallback onEliminar;

  const FilaCitaMp({
    super.key,
    required this.cita,
    required this.onConfirmar,
    required this.onEliminar,
  });

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return ListTile(
      // leading — icono con color según urgencia
      leading: CircleAvatar(
        backgroundColor: cita.urgente
            ? cs.errorContainer
            : cs.primaryContainer,
        child: Icon(
          Icons.event_note,
          color: cita.urgente ? cs.onErrorContainer : cs.onPrimaryContainer,
        ),
      ),
      title: Text(
        cita.paciente,
        style: const TextStyle(fontWeight: FontWeight.w600),
      ),
      subtitle: Text(
        '${cita.medico} · ${cita.fecha} ${cita.hora}',
        style: TextStyle(fontSize: 12, color: cs.onSurfaceVariant),
      ),
      // trailing — dos acciones compactas
      trailing: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          IconButton(
            icon: Icon(
              cita.confirmada ? Icons.check_circle : Icons.check_circle_outline,
              color: cita.confirmada ? Colors.green : cs.outline,
            ),
            onPressed:     onConfirmar,
            visualDensity: VisualDensity.compact,
            tooltip:       cita.confirmada ? 'Quitar confirmación' : 'Confirmar turno',
          ),
          IconButton(
            icon:          Icon(Icons.delete_outline, color: cs.error),
            onPressed:     onEliminar,
            visualDensity: VisualDensity.compact,
            tooltip:       'Eliminar',
          ),
        ],
      ),
      contentPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 4),
    );
  }
}
