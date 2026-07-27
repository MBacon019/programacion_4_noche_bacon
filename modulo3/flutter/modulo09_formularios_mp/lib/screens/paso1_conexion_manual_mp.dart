// lib/screens/paso1_conexion_manual_mp.dart
import 'package:flutter/material.dart';

// ─── Paso 1 — TextField + TextEditingController + FocusNode ────────────
class Paso1ConexionManualMp extends StatefulWidget {
  const Paso1ConexionManualMp({super.key});
  @override
  State<Paso1ConexionManualMp> createState() => _Paso1ConexionManualMpState();
}

class _Paso1ConexionManualMpState extends State<Paso1ConexionManualMp> {
  final _ctrlPaciente = TextEditingController();
  final _ctrlFecha    = TextEditingController();
  final _ctrlHora     = TextEditingController(text: '09:00');
  final _focusFecha   = FocusNode();
  final _focusHora    = FocusNode();

  @override
  void dispose() {
    _ctrlPaciente.dispose();
    _ctrlFecha.dispose();
    _ctrlHora.dispose();
    _focusFecha.dispose();
    _focusHora.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Nuevo turno'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller:      _ctrlPaciente,
              decoration:      const InputDecoration(
                labelText:  'Paciente',
                hintText:   'Juan Pérez',
                prefixIcon: Icon(Icons.person),
                border:     OutlineInputBorder(),
              ),
              textInputAction: TextInputAction.next,
              onSubmitted:     (_) => _focusFecha.requestFocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller:      _ctrlFecha,
              focusNode:       _focusFecha,
              decoration:      const InputDecoration(
                labelText:  'Fecha del turno',
                hintText:   '27/07/2026',
                prefixIcon: Icon(Icons.calendar_today),
                border:     OutlineInputBorder(),
              ),
              textInputAction: TextInputAction.next,
              onSubmitted:     (_) => _focusHora.requestFocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller:  _ctrlHora,
              focusNode:   _focusHora,
              decoration:  const InputDecoration(
                labelText:  'Hora',
                prefixIcon: Icon(Icons.schedule),
                border:     OutlineInputBorder(),
              ),
              textInputAction: TextInputAction.done,
              onSubmitted:     (_) => FocusScope.of(context).unfocus(),
            ),
            const SizedBox(height: 20),
            FilledButton.icon(
              onPressed: () {
                FocusScope.of(context).unfocus();
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text(
                      'Turno registrado para ${_ctrlPaciente.text} '
                      '(${_ctrlFecha.text} ${_ctrlHora.text})',
                    ),
                    behavior: SnackBarBehavior.floating,
                  ),
                );
              },
              icon:  const Icon(Icons.event_available),
              label: const Text('Registrar turno'),
            ),
            const SizedBox(height: 8),
            OutlinedButton(
              onPressed: () {
                _ctrlPaciente.clear();
                _ctrlFecha.clear();
                _ctrlHora.text = '09:00';
              },
              child: const Text('Limpiar campos'),
            ),
          ],
        ),
      ),
    );
  }
}
