// lib/widgets/formulario_cita_mp.dart
import 'package:flutter/material.dart';

class FormularioCitaMp extends StatefulWidget {
  final void Function(Map<String, String> datos) onGuardar;
  const FormularioCitaMp({super.key, required this.onGuardar});

  @override
  State<FormularioCitaMp> createState() => _FormularioCitaMpState();
}

class _FormularioCitaMpState extends State<FormularioCitaMp> {
  final _formKey = GlobalKey<FormState>();

  final _ctrlPaciente = TextEditingController();
  final _ctrlFecha     = TextEditingController();
  final _ctrlHora      = TextEditingController(text: '09:00');
  final _ctrlMedico    = TextEditingController(text: 'Dr. García');

  final _focusFecha  = FocusNode();
  final _focusHora   = FocusNode();
  final _focusMedico = FocusNode();

  String _especialidad = 'Clínica General';
  bool   _urgente       = false;

  // Expresión regular para validar fecha dd/mm/aaaa
  static final _regexFecha = RegExp(r'^(\d{1,2})/(\d{1,2})/(\d{4})$');
  // Expresión regular para validar hora HH:mm
  static final _regexHora = RegExp(r'^(\d{1,2}):(\d{2})$');

  @override
  void dispose() {
    _ctrlPaciente.dispose();
    _ctrlFecha.dispose();
    _ctrlHora.dispose();
    _ctrlMedico.dispose();
    _focusFecha.dispose();
    _focusHora.dispose();
    _focusMedico.dispose();
    super.dispose();
  }

  void _guardar() {
    // validate() llama al validator de TODOS los TextFormField del Form
    if (!_formKey.currentState!.validate()) return;

    widget.onGuardar({
      'paciente':     _ctrlPaciente.text,
      'fecha':        _ctrlFecha.text,
      'hora':         _ctrlHora.text,
      'medico':       _ctrlMedico.text,
      'especialidad': _especialidad,
      'urgente':      _urgente.toString(),
    });
  }

  @override
  Widget build(BuildContext context) {
    return Form(
      key: _formKey,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [

          // ── Nombre del paciente ───────────────────────────────────
          TextFormField(
            controller:      _ctrlPaciente,
            decoration:      const InputDecoration(
              labelText:  'Nombre del paciente',
              hintText:   'Juan Pérez',
              prefixIcon: Icon(Icons.person),
              border:     OutlineInputBorder(),
            ),
            textInputAction: TextInputAction.next,
            onFieldSubmitted: (_) => _focusFecha.requestFocus(),
            validator: (v) {
              if (v == null || v.trim().isEmpty) return 'El paciente es obligatorio';
              if (v.length < 3)                  return 'Mínimo 3 caracteres';
              if (!RegExp(r'^[a-zA-ZÀ-ÿ\s]+$').hasMatch(v))
                return 'Solo letras y espacios';
              return null;
            },
          ),
          const SizedBox(height: 12),

          // ── Fecha del turno ───────────────────────────────────────
          TextFormField(
            controller:      _ctrlFecha,
            focusNode:       _focusFecha,
            decoration:      const InputDecoration(
              labelText:  'Fecha del turno',
              hintText:   '27/07/2026',
              prefixIcon: Icon(Icons.calendar_today),
              border:     OutlineInputBorder(),
            ),
            keyboardType:    TextInputType.datetime,
            textInputAction: TextInputAction.next,
            onFieldSubmitted: (_) => _focusHora.requestFocus(),
            validator: (v) {
              if (v == null || v.isEmpty) return 'La fecha es obligatoria';
              final m = _regexFecha.firstMatch(v);
              if (m == null) return 'Formato dd/mm/aaaa inválido (ej. 27/07/2026)';
              final dia = int.parse(m.group(1)!);
              final mes = int.parse(m.group(2)!);
              if (dia < 1 || dia > 31) return 'Día fuera de rango (1–31)';
              if (mes < 1 || mes > 12) return 'Mes fuera de rango (1–12)';
              return null;
            },
          ),
          const SizedBox(height: 12),

          // ── Hora del turno ────────────────────────────────────────
          TextFormField(
            controller:      _ctrlHora,
            focusNode:       _focusHora,
            decoration:      const InputDecoration(
              labelText:  'Hora',
              hintText:   '09:00',
              prefixIcon: Icon(Icons.schedule),
              border:     OutlineInputBorder(),
            ),
            textInputAction: TextInputAction.next,
            onFieldSubmitted: (_) => _focusMedico.requestFocus(),
            validator: (v) {
              final m = v == null ? null : _regexHora.firstMatch(v);
              if (m == null) return 'Formato HH:mm inválido (ej. 09:00)';
              final hh = int.parse(m.group(1)!);
              final mm = int.parse(m.group(2)!);
              if (hh < 0 || hh > 23) return 'Hora entre 0 y 23';
              if (mm < 0 || mm > 59) return 'Minutos entre 0 y 59';
              return null;
            },
          ),
          const SizedBox(height: 12),

          // ── Médico ────────────────────────────────────────────────
          TextFormField(
            controller:      _ctrlMedico,
            focusNode:       _focusMedico,
            decoration:      const InputDecoration(
              labelText:  'Médico',
              prefixIcon: Icon(Icons.medical_services_outlined),
              border:     OutlineInputBorder(),
            ),
            textInputAction: TextInputAction.next,
            validator: (v) =>
                v == null || v.trim().isEmpty ? 'El médico es obligatorio' : null,
          ),
          const SizedBox(height: 12),

          // ── Especialidad — DropdownButtonFormField ──────────────────
          DropdownButtonFormField<String>(
            value:      _especialidad,
            decoration: const InputDecoration(
              labelText:  'Especialidad',
              prefixIcon: Icon(Icons.local_hospital),
              border:     OutlineInputBorder(),
            ),
            items: [
              'Clínica General', 'Cardiología', 'Pediatría',
              'Traumatología', 'Dermatología',
            ].map((e) => DropdownMenuItem(value: e, child: Text(e))).toList(),
            onChanged: (v) => setState(() => _especialidad = v!),
          ),
          const SizedBox(height: 8),

          // ── Urgente — SwitchListTile ──────────────────────────────
          SwitchListTile(
            title:     const Text('Turno urgente'),
            subtitle:  const Text('Requiere atención prioritaria'),
            value:     _urgente,
            onChanged: (v) => setState(() => _urgente = v),
            secondary: const Icon(Icons.priority_high),
          ),
          const SizedBox(height: 16),

          // ── Botones ───────────────────────────────────────────────
          Row(children: [
            Expanded(
              child: OutlinedButton(
                onPressed: () => _formKey.currentState?.reset(),
                child: const Text('Limpiar'),
              ),
            ),
            const SizedBox(width: 12),
            Expanded(
              flex: 2,
              child: FilledButton.icon(
                onPressed: _guardar,
                icon:  const Icon(Icons.save),
                label: const Text('Guardar turno'),
              ),
            ),
          ]),
        ],
      ),
    );
  }
}
