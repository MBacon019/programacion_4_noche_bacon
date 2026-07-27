// lib/screens/pantalla_citas_mp.dart
import 'package:flutter/material.dart';
import '../models/cita_mp.dart';
import '../widgets/fila_cita_mp.dart';
import '../widgets/tarjeta_cita_grid_mp.dart';

// ─── Paso 4 — GridView.builder + toggle lista/grid ──────────────────────
class PantallaCitasMp extends StatefulWidget {
  const PantallaCitasMp({super.key});
  @override
  State<PantallaCitasMp> createState() => _PantallaCitasMpState();
}

class _PantallaCitasMpState extends State<PantallaCitasMp> {
  final _citas = [
    Cita(id:'1', paciente:'Juan Pérez',    especialidad:'Cardiología',     fecha:'27/07/2026', hora:'09:00', medico:'Dra. Ríos',   urgente:true,  confirmada:true),
    Cita(id:'2', paciente:'María Gómez',   especialidad:'Clínica General', fecha:'27/07/2026', hora:'10:30', medico:'Dr. López',   urgente:false, confirmada:true),
    Cita(id:'3', paciente:'Carlos Ruiz',   especialidad:'Pediatría',       fecha:'28/07/2026', hora:'11:15', medico:'Dra. Fabbri', urgente:false, confirmada:false),
    Cita(id:'4', paciente:'Lucía Fernández', especialidad:'Dermatología',  fecha:'28/07/2026', hora:'16:00', medico:'Dr. Suárez',  urgente:false, confirmada:false),
  ];

  bool _modoGrid = false;   // false = lista, true = cuadrícula

  void _toggleConfirmar(int i) =>
      setState(() => _citas[i].confirmada = !_citas[i].confirmada);

  void _eliminar(int i) => setState(() => _citas.removeAt(i));

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Turnos (${_citas.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
        actions: [
          // Toggle lista / cuadrícula
          IconButton(
            icon:    Icon(_modoGrid ? Icons.list : Icons.grid_view),
            onPressed: () => setState(() => _modoGrid = !_modoGrid),
            tooltip: _modoGrid ? 'Vista lista' : 'Vista cuadrícula',
          ),
        ],
      ),
      body: _modoGrid
          ? GridView.builder(
              padding: const EdgeInsets.all(12),
              gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount:   2,
                childAspectRatio: 1.1,
                crossAxisSpacing: 8,
                mainAxisSpacing:  8,
              ),
              itemCount:   _citas.length,
              itemBuilder: (ctx, i) => TarjetaCitaGridMp(
                cita:        _citas[i],
                onConfirmar: () => _toggleConfirmar(i),
                onEliminar:  () => _eliminar(i),
              ),
            )
          : ListView.separated(
              itemCount:        _citas.length,
              separatorBuilder: (_, __) =>
                  const Divider(height: 1, indent: 72),
              itemBuilder: (ctx, i) => FilaCitaMp(
                cita:        _citas[i],
                onConfirmar: () => _toggleConfirmar(i),
                onEliminar:  () => _eliminar(i),
              ),
            ),
    );
  }
}
