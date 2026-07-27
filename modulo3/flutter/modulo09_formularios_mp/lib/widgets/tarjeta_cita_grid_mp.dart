// lib/widgets/tarjeta_cita_grid_mp.dart
import 'package:flutter/material.dart';
import '../models/cita_mp.dart';

class TarjetaCitaGridMp extends StatelessWidget {
  final Cita         cita;
  final VoidCallback onConfirmar;
  final VoidCallback onEliminar;

  const TarjetaCitaGridMp({
    super.key,
    required this.cita,
    required this.onConfirmar,
    required this.onEliminar,
  });

  @override
  Widget build(BuildContext context) {
    final cs   = Theme.of(context).colorScheme;
    final text = Theme.of(context).textTheme;

    return Card(
      child: Padding(
        padding: const EdgeInsets.all(10),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Fila superior: icono + confirmar
            Row(children: [
              Icon(
                Icons.event_note,
                color: cita.urgente ? cs.error : cs.primary,
                size: 18,
              ),
              const Spacer(),
              GestureDetector(
                onTap: onConfirmar,
                child: Icon(
                  cita.confirmada ? Icons.check_circle : Icons.check_circle_outline,
                  color: cita.confirmada ? Colors.green : cs.outline,
                  size: 18,
                ),
              ),
            ]),
            const SizedBox(height: 6),

            // Paciente y fecha
            Text(
              cita.paciente,
              style: text.titleSmall?.copyWith(fontWeight: FontWeight.bold),
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
            ),
            Text(
              '${cita.fecha} ${cita.hora}',
              style: text.bodySmall?.copyWith(color: cs.onSurfaceVariant),
            ),

            const Spacer(),

            // Fila inferior: urgente + médico + eliminar
            Row(children: [
              if (cita.urgente)
                Padding(
                  padding: const EdgeInsets.only(right: 4),
                  child: Icon(Icons.priority_high, size: 12, color: cs.error),
                ),
              Expanded(
                child: Text(
                  cita.medico,
                  style: text.labelSmall?.copyWith(color: cs.onSurfaceVariant),
                  overflow: TextOverflow.ellipsis,
                ),
              ),
              GestureDetector(
                onTap: onEliminar,
                child: Icon(Icons.delete_outline, size: 16, color: cs.error),
              ),
            ]),
          ],
        ),
      ),
    );
  }
}
