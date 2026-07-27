// lib/screens/paso3_lista_citas_mp.dart
import 'package:flutter/material.dart';
import '../models/cita_mp.dart';
import '../widgets/fila_cita_mp.dart';

// ─── Paso 3 — Modelo + ListView.builder + ListTile acciones ────────────
class Paso3ListaCitasMp extends StatefulWidget {
  const Paso3ListaCitasMp({super.key});
  @override
  State<Paso3ListaCitasMp> createState() => _Paso3ListaCitasMpState();
}

class _Paso3ListaCitasMpState extends State<Paso3ListaCitasMp> {
  final _citas = [
    Cita(id:'1', paciente:'Juan Pérez',    especialidad:'Cardiología',     fecha:'27/07/2026', hora:'09:00', medico:'Dra. Ríos',   urgente:true,  confirmada:true),
    Cita(id:'2', paciente:'María Gómez',   especialidad:'Clínica General', fecha:'27/07/2026', hora:'10:30', medico:'Dr. López',   urgente:false, confirmada:true),
    Cita(id:'3', paciente:'Carlos Ruiz',   especialidad:'Pediatría',       fecha:'28/07/2026', hora:'11:15', medico:'Dra. Fabbri', urgente:false, confirmada:false),
    Cita(id:'4', paciente:'Lucía Fernández', especialidad:'Dermatología',  fecha:'28/07/2026', hora:'16:00', medico:'Dr. Suárez',  urgente:false, confirmada:false),
  ];

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Turnos (${_citas.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: _citas.isEmpty
          ? Center(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Icon(Icons.event_busy, size: 56, color: cs.onSurfaceVariant),
                  const SizedBox(height: 12),
                  Text('Sin turnos',
                      style: TextStyle(color: cs.onSurfaceVariant)),
                ],
              ),
            )
          : ListView.separated(
              itemCount:        _citas.length,
              separatorBuilder: (_, __) =>
                  const Divider(height: 1, indent: 72),
              itemBuilder: (ctx, i) => FilaCitaMp(
                cita:        _citas[i],
                onConfirmar: () => setState(() =>
                    _citas[i].confirmada = !_citas[i].confirmada),
                onEliminar:  () => setState(() => _citas.removeAt(i)),
              ),
            ),
    );
  }
}
