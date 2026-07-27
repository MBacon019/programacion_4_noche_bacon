// lib/screens/pantalla_busqueda_citas_mp.dart
import 'package:flutter/material.dart';
import '../models/cita_mp.dart';
import '../widgets/fila_cita_mp.dart';
import '../widgets/tarjeta_cita_grid_mp.dart';

// ─── Paso 5 — SearchBar + filtrado en tiempo real ───────────────────────
class PantallaBusquedaCitasMp extends StatefulWidget {
  const PantallaBusquedaCitasMp({super.key});
  @override
  State<PantallaBusquedaCitasMp> createState() => _PantallaBusquedaCitasMpState();
}

class _PantallaBusquedaCitasMpState extends State<PantallaBusquedaCitasMp> {
  final _citas = [
    Cita(id:'1', paciente:'Juan Pérez',    especialidad:'Cardiología',     fecha:'27/07/2026', hora:'09:00', medico:'Dra. Ríos',   urgente:true,  confirmada:true),
    Cita(id:'2', paciente:'María Gómez',   especialidad:'Clínica General', fecha:'27/07/2026', hora:'10:30', medico:'Dr. López',   urgente:false, confirmada:true),
    Cita(id:'3', paciente:'Carlos Ruiz',   especialidad:'Pediatría',       fecha:'28/07/2026', hora:'11:15', medico:'Dra. Fabbri', urgente:false, confirmada:false),
    Cita(id:'4', paciente:'Lucía Fernández', especialidad:'Dermatología',  fecha:'28/07/2026', hora:'16:00', medico:'Dr. Suárez',  urgente:false, confirmada:false),
  ];

  String _busqueda = '';     // texto actual de la búsqueda
  bool   _modoGrid = false;

  // Getter calculado — filtra sin modificar _citas
  List<Cita> get _filtrados => _citas
      .where((c) =>
          c.paciente.toLowerCase().contains(_busqueda.toLowerCase()) ||
          c.medico.toLowerCase().contains(_busqueda.toLowerCase()) ||
          c.especialidad.toLowerCase().contains(_busqueda.toLowerCase()))
      .toList();

  void _toggleConfirmar(Cita c) =>
      setState(() => c.confirmada = !c.confirmada);

  void _eliminar(Cita c) =>
      setState(() => _citas.removeWhere((x) => x.id == c.id));

  @override
  Widget build(BuildContext context) {
    final cs        = Theme.of(context).colorScheme;
    final filtrados = _filtrados;   // evalúa el getter una sola vez

    return Scaffold(
      appBar: AppBar(
        title:           Text('Turnos (${_citas.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
        actions: [
          IconButton(
            icon:      Icon(_modoGrid ? Icons.list : Icons.grid_view),
            onPressed: () => setState(() => _modoGrid = !_modoGrid),
            tooltip:   _modoGrid ? 'Vista lista' : 'Vista cuadrícula',
          ),
        ],
      ),
      body: Column(
        children: [
          // ── SearchBar ─────────────────────────────────────────────
          Padding(
            padding: const EdgeInsets.fromLTRB(16, 12, 16, 8),
            child: SearchBar(
              hintText: 'Buscar por paciente, médico o especialidad...',
              leading:  const Icon(Icons.search),
              trailing: _busqueda.isNotEmpty
                  ? [
                      IconButton(
                        icon:      const Icon(Icons.clear),
                        onPressed: () => setState(() => _busqueda = ''),
                      ),
                    ]
                  : null,
              onChanged: (v) => setState(() => _busqueda = v),
              padding: const WidgetStatePropertyAll(
                EdgeInsets.symmetric(horizontal: 16),
              ),
            ),
          ),

          // ── Contador de resultados ────────────────────────────────
          if (_busqueda.isNotEmpty)
            Padding(
              padding: const EdgeInsets.only(left: 16, bottom: 4),
              child: Align(
                alignment: Alignment.centerLeft,
                child: Text(
                  '${filtrados.length} resultado${filtrados.length == 1 ? '' : 's'}',
                  style: Theme.of(context).textTheme.labelMedium?.copyWith(
                    color: cs.onSurfaceVariant,
                  ),
                ),
              ),
            ),

          // ── Lista o Grid ──────────────────────────────────────────
          Expanded(
            child: filtrados.isEmpty
                ? Center(
                    child: Column(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Icon(Icons.search_off,
                            size: 56, color: cs.onSurfaceVariant),
                        const SizedBox(height: 12),
                        Text(
                          'Sin resultados para "$_busqueda"',
                          style: TextStyle(color: cs.onSurfaceVariant),
                        ),
                        const SizedBox(height: 8),
                        TextButton(
                          onPressed: () => setState(() => _busqueda = ''),
                          child: const Text('Limpiar búsqueda'),
                        ),
                      ],
                    ),
                  )
                : _modoGrid
                    ? GridView.builder(
                        padding: const EdgeInsets.all(12),
                        gridDelegate:
                            const SliverGridDelegateWithFixedCrossAxisCount(
                          crossAxisCount:   2,
                          childAspectRatio: 1.1,
                          crossAxisSpacing: 8,
                          mainAxisSpacing:  8,
                        ),
                        itemCount:   filtrados.length,
                        itemBuilder: (ctx, i) => TarjetaCitaGridMp(
                          cita:        filtrados[i],
                          onConfirmar: () => _toggleConfirmar(filtrados[i]),
                          onEliminar:  () => _eliminar(filtrados[i]),
                        ),
                      )
                    : ListView.separated(
                        itemCount:        filtrados.length,
                        separatorBuilder: (_, __) =>
                            const Divider(height: 1, indent: 72),
                        itemBuilder: (ctx, i) => FilaCitaMp(
                          cita:        filtrados[i],
                          onConfirmar: () => _toggleConfirmar(filtrados[i]),
                          onEliminar:  () => _eliminar(filtrados[i]),
                        ),
                      ),
          ),
        ],
      ),
    );
  }
}
