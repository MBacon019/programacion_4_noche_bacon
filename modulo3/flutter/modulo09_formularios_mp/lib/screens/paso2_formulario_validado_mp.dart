// lib/screens/paso2_formulario_validado_mp.dart
import 'package:flutter/material.dart';
import '../widgets/formulario_cita_mp.dart';

// ─── Paso 2 — Form + TextFormField + validación ─────────────────────────
class Paso2FormularioValidadoMp extends StatelessWidget {
  const Paso2FormularioValidadoMp({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Nuevo turno')),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: FormularioCitaMp(
          onGuardar: (datos) {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                content: Text('Turno de "${datos['paciente']}" guardado'),
                behavior: SnackBarBehavior.floating,
              ),
            );
          },
        ),
      ),
    );
  }
}
