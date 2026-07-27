// lib/widget/paso1_contenedor_mp.dart
// Paso 1 — Container: decoración y espaciado (extraído del router)
import 'package:flutter/material.dart';

Widget paso1Contenedor() => Scaffold(
  body: Center(
    child: Container(
      width:   double.infinity,
      height:  80,
      margin: const EdgeInsets.all(24),
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
      decoration: BoxDecoration(
        color:        Colors.indigo.shade50,
        borderRadius: BorderRadius.circular(40),
        border:       Border(left: BorderSide(color: Colors.indigo, width: 4)),
        boxShadow: [
          BoxShadow(
            color:      Colors.black.withOpacity(0.3),
            blurRadius: 8,
            offset:     const Offset(0, 2),
          ),
        ],
      ),
      child: const Text('Paciente: Juan Pérez — Sala 204',
          style: TextStyle(fontWeight: FontWeight.bold)),
    ),
  ),
);
