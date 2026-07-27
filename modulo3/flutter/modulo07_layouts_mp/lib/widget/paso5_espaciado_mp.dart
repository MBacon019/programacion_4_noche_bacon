// lib/widget/paso5_espaciado_mp.dart
// Paso 5 — SizedBox, Padding, Align, Wrap (extraído del router)
import 'package:flutter/material.dart';

Widget paso5Espaciado() => Scaffold(
  body: ListView(
    padding: const EdgeInsets.all(16),
    children: [
      // SizedBox — espaciado fijo
      const Text('SizedBox', style: TextStyle(fontWeight: FontWeight.bold)),
      const SizedBox(height: 8),
      const Text('Primer turno del día'),
      const SizedBox(height: 32),          // ← espacio fijo de 32px
      const Text('Segundo turno (después de 32px)'),

      const Divider(height: 32),

      // Padding — espacio alrededor de un hijo
      const Text('Padding', style: TextStyle(fontWeight: FontWeight.bold)),
      const SizedBox(height: 8),
      Container(
        color: Colors.indigo.shade50,
        child: const Padding(
          padding: EdgeInsets.only(left: 24),    // ← sangría izquierda
          child:   Text('Antecedente registrado con sangría'),
        ),
      ),

      const Divider(height: 32),

      // Align — posicionar dentro del espacio disponible
      const Text('Align', style: TextStyle(fontWeight: FontWeight.bold)),
      const SizedBox(height: 8),
      const Align(
        alignment: Alignment.centerRight,        // ← borde derecho
        child: Icon(Icons.medical_services, color: Colors.indigo),
      ),

      const Divider(height: 32),

      // Wrap — flujo automático de elementos
      const Text('Wrap', style: TextStyle(fontWeight: FontWeight.bold)),
      const SizedBox(height: 8),
      Wrap(
        spacing:    8,
        runSpacing: 8,
        children: ['Cardiología', 'Pediatría', 'Guardia 24hs', 'Telemedicina', 'Laboratorio', 'Rayos X', 'Farmacia']
            .map((t) => Chip(label: Text(t)))
            .toList(),
      ),
    ],
  ),
);
