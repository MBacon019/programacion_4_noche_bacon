// lib/main.dart
import 'package:flutter/material.dart';
import 'package:modulo07_layouts_mp/widget/avatar_badge_mp.dart';
import 'package:modulo07_layouts_mp/widget/tarjeta_log_mp.dart';
import 'package:modulo07_layouts_mp/widget/fila_estado_mp.dart';
import 'package:modulo07_layouts_mp/widget/paso1_contenedor_mp.dart';
import 'package:modulo07_layouts_mp/widget/paso5_espaciado_mp.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  Container — decoración y espaciado                  │
// │  2  Paso 2  Column — TarjetaEvolucion                           │
// │  3  Paso 3  Row + Expanded + Spacer — FilaEstadoPaciente        │
// │  4  Paso 4  Stack + Positioned — AvatarPacienteBadge            │
// │  5  Paso 5  SizedBox, Padding, Align, Wrap                      │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 5;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  home: switch (paso) {
    1 => paso1Contenedor(),
     2 => Scaffold(
      body: ListView(
        children: [
          TarjetaEvolucion(nivel: 'CRÍTICO', paciente: 'Paciente García, M.',
              observacion: 'Saturación de oxígeno por debajo de 90% — requiere intervención inmediata',
              timestamp:   DateTime.now()),
          TarjetaEvolucion(nivel: 'ALERTA',  paciente: 'Paciente Ramírez, J.',
              observacion: 'Presión arterial elevada: 160/100 mmHg',
              timestamp:   DateTime.now().subtract(const Duration(minutes: 2))),
          TarjetaEvolucion(nivel: 'CONTROL', paciente: 'Paciente Torres, L.',
              observacion: 'Signos vitales estables — control de rutina completado',
              timestamp:   DateTime.now().subtract(const Duration(minutes: 5))),
          TarjetaEvolucion(nivel: 'RUTINA',  paciente: 'Paciente Fernández, A.',
              observacion: 'Medicación administrada según indicación (08:00hs)',
              timestamp:   DateTime.now().subtract(const Duration(minutes: 8))),
        ],
      ),
    ),
    3 => const Scaffold(
      body: Column(
        children: [
          FilaEstadoPaciente(nombre: 'Paciente Suárez, R.',    detalle: 'Sala 204 · signos vitales estables', activo: true),
          Divider(height: 1),
          FilaEstadoPaciente(nombre: 'Paciente Domínguez, C.', detalle: 'Sala 108 · monitoreo continuo',      activo: true),
          Divider(height: 1),
          FilaEstadoPaciente(nombre: 'Paciente Vega, N.',      detalle: 'Sala 15 · sin respuesta del monitor', activo: false),
          Divider(height: 1),
          FilaEstadoPaciente(nombre: 'Paciente García-Fernández de la Torre, Sofía',
                     detalle: 'UCI · post-operatorio inmediato', activo: true),
        ],
      ),
    ),
    4 => Scaffold(
      body: Center(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Column(mainAxisSize: MainAxisSize.min, children: [
              AvatarPacienteBadge(nombre: 'Dr. Paz',    alertas: 2,  activo: true),
              SizedBox(height: 4),
              Text('Dr. Paz', style: TextStyle(fontSize: 11, color: Colors.grey.shade600)),
            ]),
            SizedBox(width: 24),
            Column(mainAxisSize: MainAxisSize.min, children: [
              AvatarPacienteBadge(nombre: 'Dra. Ríos',  alertas: 0,  activo: true),
              SizedBox(height: 4),
              Text('Dra. Ríos', style: TextStyle(fontSize: 11, color: Colors.grey.shade600)),
            ]),
            SizedBox(width: 24),
            Column(mainAxisSize: MainAxisSize.min, children: [
              AvatarPacienteBadge(nombre: 'Enf. Cruz', alertas: 0,  activo: false),
              SizedBox(height: 4),
              Text('Enf. Cruz', style: TextStyle(fontSize: 11, color: Colors.grey.shade600)),
            ]),
            SizedBox(width: 24),
            Column(mainAxisSize: MainAxisSize.min, children: [
              AvatarPacienteBadge(nombre: 'Farmacia', alertas: 11, activo: true),
              SizedBox(height: 4),
              Text('Farmacia', style: TextStyle(fontSize: 11, color: Colors.grey.shade600)),
            ]),
            SizedBox(width: 24),
            Column(mainAxisSize: MainAxisSize.min, children: [
              AvatarPacienteBadge(nombre: 'Laboratorio', alertas: 5,  activo: false),
              SizedBox(height: 4),
              Text('Laboratorio', style: TextStyle(fontSize: 11, color: Colors.grey.shade600)),
            ]),

          ],
        ),
      ),
    ),
    5 => paso5Espaciado(),
    _ => Scaffold(body: Center(child: Text('Paso $paso: crea el widget primero'))),
  },
));
