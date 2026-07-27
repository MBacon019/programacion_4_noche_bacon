// lib/screens/paso1_contador_citas_mp.dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:flutter_riverpod/legacy.dart';

// StateProvider — estado simple del Paso 1
final contadorTurnosProvider = StateProvider<int>((ref) => 0);

// ─── Paso 1 — ProviderScope + StateProvider básico (contador) ──────────
class Paso1ContadorCitasMp extends ConsumerWidget {
  const Paso1ContadorCitasMp({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final count = ref.watch(contadorTurnosProvider);

    return Scaffold(
      appBar: AppBar(title: const Text('Turnos agendados hoy')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text('$count', style: Theme.of(context).textTheme.displayLarge),
            const Text('turnos agendados'),
          ],
        ),
      ),
      floatingActionButton: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          FloatingActionButton(
            heroTag: 'add',
            onPressed: () => ref.read(contadorTurnosProvider.notifier).state++,
            child: const Icon(Icons.add),
          ),
          const SizedBox(height: 8),
          FloatingActionButton(
            heroTag: 'rem',
            onPressed: () {
              if (ref.read(contadorTurnosProvider) > 0) {
                ref.read(contadorTurnosProvider.notifier).state--;
              }
            },
            child: const Icon(Icons.remove),
          ),
        ],
      ),
    );
  }
}
