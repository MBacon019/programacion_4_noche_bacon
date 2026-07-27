// lib/screens/pantalla_busqueda_citas_mp.dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../providers/citas_provider_mp.dart';

// ─── Paso 3 — Provider derivado + búsqueda filtrada ─────────────────────
class PantallaBusquedaCitasMp extends ConsumerWidget {
  const PantallaBusquedaCitasMp({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final citas    = ref.watch(citasFiltradasProvider);
    final busqueda = ref.watch(busquedaProvider);

    return Scaffold(
      appBar: AppBar(title: const Text('Buscar turnos')),
      body: Column(children: [
        Padding(
          padding: const EdgeInsets.all(12),
          child: SearchBar(
            hintText: 'Buscar por paciente o fecha...',
            leading:  const Icon(Icons.search),
            trailing: busqueda.isNotEmpty
                ? [IconButton(
                    icon: const Icon(Icons.clear),
                    onPressed: () =>
                        ref.read(busquedaProvider.notifier).state = '',
                  )]
                : null,
            onChanged: (v) =>
                ref.read(busquedaProvider.notifier).state = v,
            padding: const WidgetStatePropertyAll(
              EdgeInsets.symmetric(horizontal: 16),
            ),
          ),
        ),
        Expanded(
          child: citas.isEmpty
              ? const Center(child: Text('Sin resultados'))
              : ListView.builder(
                  itemCount:   citas.length,
                  itemBuilder: (_, i) => ListTile(
                    leading: const Icon(Icons.event_note),
                    title:    Text(citas[i].paciente),
                    subtitle: Text('${citas[i].fecha} · ${citas[i].hora}'),
                  ),
                ),
        ),
      ]),
    );
  }
}
