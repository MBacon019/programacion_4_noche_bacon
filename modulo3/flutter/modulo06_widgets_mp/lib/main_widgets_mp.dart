// lib/main_widgets_mp.dart
import 'package:flutter/material.dart';

void main() => runApp(
  const MaterialApp(
    home: Scaffold(body: Center(child: SaludoPaciente())),
  ),
);

class SaludoPaciente extends StatelessWidget {
  const SaludoPaciente({super.key});

  @override
  Widget build(BuildContext context) {
    // describe cómo se ve
    return const Text(
      'Bienvenido, Paciente',
      textAlign: TextAlign.center,
      maxLines: 1,
      overflow: TextOverflow.ellipsis,
      style: TextStyle(
        fontSize: 32,
        fontWeight: FontWeight.bold,
        letterSpacing: 4,
        color: Colors.indigo, // Cambia aquí a Colors.teal o Colors.deepOrange
        shadows: [
          Shadow(color: Colors.black26, blurRadius: 4, offset: Offset(2, 2)),
        ],
      ),
    );
  }
}
