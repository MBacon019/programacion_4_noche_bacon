// lib/widgets/catalogo_botones_mp.dart
import 'package:flutter/material.dart';

class CatalogoBotonesMedico extends StatelessWidget {
  const CatalogoBotonesMedico({super.key});

  @override
  Widget build(BuildContext context) {
    final cs   = Theme.of(context).colorScheme;
    final text = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Botones Material 3 — Consultorio'),
        backgroundColor: cs.surfaceContainerHighest,
        actions: [
          IconButton(
            icon: const Icon(Icons.delete),
            onPressed: () {},
            tooltip: 'Eliminar',
          ),
        ],
      ),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [

          // ── Los 5 variantes ──────────────────────────────────────
          Text('Variantes — de mayor a menor énfasis',
              style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          FilledButton(
            onPressed: () {},
            child: const Text('FilledButton — confirmar turno'),
          ),
          const SizedBox(height: 8),
          FilledButton.tonal(
            onPressed: () {},
            child: const Text('FilledButton.tonal — reprogramar turno'),
          ),
          const SizedBox(height: 8),
          ElevatedButton(
            onPressed: () {},
            child: const Text('ElevatedButton — acción con sombra'),
          ),
          const SizedBox(height: 8),
          FilledButton.tonal(
            onPressed: () {},
            child: const Text('FilledButton.tonal — antes OutlinedButton'),
          ),
          const SizedBox(height: 8),
          TextButton(
            onPressed: () {},
            child: const Text('TextButton — acción mínima'),
          ),

          const Divider(height: 32),

          // ── Con ícono ────────────────────────────────────────────
          Text('Con ícono',
              style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          FilledButton.icon(
            onPressed: () {},
            icon:  const Icon(Icons.send),
            label: const Text('Enviar receta'),
          ),
          const SizedBox(height: 8),
          OutlinedButton.icon(
            onPressed: () {},
            icon:  const Icon(Icons.download),
            label: const Text('Descargar historia clínica'),
          ),
          const SizedBox(height: 8),
          TextButton.icon(
            onPressed: () {},
            icon:  const Icon(Icons.open_in_new),
            label: const Text('Ver documentación médica'),
          ),

          const Divider(height: 32),

          // ── Estados y personalización ────────────────────────────
          Text('Estados y personalización',
              style: text.labelLarge?.copyWith(color: cs.primary)),
          const SizedBox(height: 12),
          FilledButton(
            onPressed: null,               // null = deshabilitado
            child: const Text('No disponible'),
          ),
          const SizedBox(height: 8),
          FilledButton(
            style: FilledButton.styleFrom(
              backgroundColor: cs.errorContainer,
              foregroundColor: cs.onErrorContainer,
              minimumSize:     const Size(double.infinity, 48),
            ),
            onPressed: () {},
            child: const Text('Eliminar paciente'),
          ),
          const SizedBox(height: 8),
          // Fila de botones compactos
          Row(children: [
            Expanded(
              child: OutlinedButton(onPressed: () {}, child: const Text('Reprogramar')),
            ),
            const SizedBox(width: 8),
            Expanded(
              child: FilledButton(onPressed: () {}, child: const Text('Cancelar turno')),
            ),
          ]),
          const SizedBox(height: 8),
          Center(
            child: IconButton(
              icon: const Icon(Icons.delete),
              onPressed: () {},
              tooltip: 'Eliminar',
            ),
          ),
        ],
      ),
    );
  }
}
