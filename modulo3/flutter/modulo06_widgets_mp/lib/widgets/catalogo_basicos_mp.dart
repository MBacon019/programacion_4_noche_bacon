import 'package:flutter/material.dart';

class CatalogoBasicosMedico extends StatelessWidget {
  const CatalogoBasicosMedico({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Widgets básicos — Consultorio')),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [
          // ── Text básico ───────────────────────────────────────────────────────
Text(
  'Turno confirmado — paciente en sala de espera',
  maxLines:  2,
  style: TextStyle(
    shadows: [Shadow(color: Colors.black26, blurRadius: 4, offset: Offset(2,2))],
    fontSize:      20,
    fontWeight:    FontWeight.bold,    // .w100–.w900  ·  .bold = .w700
    color:         Colors.green,
    letterSpacing: 0.5,
    fontStyle:     FontStyle.normal,   // .italic
    decoration:    TextDecoration.combine([TextDecoration.underline, TextDecoration.lineThrough]),
    //             .underline  .lineThrough  .overline
  ),
),
const SizedBox(height: 8),

// ── Alineación y desbordamiento ───────────────────────────────────────
SizedBox(
  width: double.infinity,
  child: Text(
    'EL CONSULTORIO SE ENCUENTRA DISPONIBLE',
    textAlign: TextAlign.justify,        // .left  .right  .justify  .start  .end
    maxLines:  2,
    softWrap:  false,
    overflow:  .fade,   // .clip  .fade  .visible
  ),
),
const SizedBox(height: 8),

// ── Overflow .clip ────────────────────────────────────────────────────
SizedBox(
  width: 200,
  child: Text(
    'TODO EL EQUIPO MEDICO ESTA DE GUARDIA HOY',
    maxLines:  1,
    overflow:  TextOverflow.clip,
  ),
),
const SizedBox(height: 8),

// ── Text.rich — estilos distintos en un solo widget ───────────────────
const Text.rich(
  TextSpan(children: [
    TextSpan(text: 'Prioridad: ',
        style: TextStyle(fontWeight: FontWeight.w600)),
    TextSpan(text: 'URGENTE',
        style: TextStyle(color: Colors.red, fontWeight: FontWeight.bold)),
    TextSpan(text: ' — triage realizado hace 5 min',
        style: TextStyle(color: Colors.grey, fontSize: 12)),
  ]),
),
const SizedBox(height: 8),

// ── SelectableText — el usuario puede seleccionar y copiar ───────────
const SelectableText(
  'HC-0231087',
  style: TextStyle(fontFamily: 'monospace', fontSize: 14),
),
const Divider(height: 32),
// Agrega a children: [ ... ]

Row(
  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
  children: [
    Tooltip(
      message: 'Paciente estable',
      child: Icon(Icons.check_circle_outline, size: 80,
          color: Theme.of(context).colorScheme.primary),
    ),
    const Icon(Icons.cancel,        size: 14, color: Colors.red),
    const Icon(Icons.warning_amber, size: 40, color: Colors.orange),
    const Icon(Icons.local_hospital, size: 40, color: Colors.indigo),
    const Icon(Icons.event_busy,    size: 40, color: Colors.grey),
  ],
),
const SizedBox(height: 8),
const Icon(Icons.settings,
    size:          24,
    color:         Colors.blueGrey,
    semanticLabel: 'Configuración de agenda'),   // leído por lectores de pantalla
const Divider(height: 32),
// Agrega a children: [ ... ]

// ── Cuatro variantes ──────────────────────────────────────────────────
Wrap(
  spacing: 8, runSpacing: 8,
  children: [
    ElevatedButton(onPressed: () {}, child: const Text('ElevatedButton')),
    FilledButton(  onPressed: () {}, child: const Text('FilledButton')),
    OutlinedButton(onPressed: () {}, child: const Text('OutlinedButton')),
    TextButton(    onPressed: () {}, child: const Text('TextButton')),
    ElevatedButton(onPressed: () {}, child: const Text('Desactivado')),
  ],
),
const SizedBox(height: 12),

// ── Variantes .icon ───────────────────────────────────────────────────
Wrap(
  spacing: 8, runSpacing: 8,
  children: [
    ElevatedButton.icon(
      onPressed: () {},
      icon:  const Icon(Icons.refresh, size: 18),
      label: const Text('Actualizar turnos'),
    ),
    FilledButton.icon(
      onPressed: () {},
      icon:  const Icon(Icons.stop, size: 18),
      label: const Text('Cancelar turno'),
    ),
    TextButton.icon(
      onPressed: () {},
      icon:  const Icon(Icons.edit, size: 18),
      label: const Text('Editar historia clínica'),
    ),
    OutlinedButton.icon(
      onPressed: () {},
      icon:  const Icon(Icons.delete, size: 18),
      label: const Text('Eliminar registro'),
    ),
    IconButton(
      onPressed: () {},
      icon:     const Icon(Icons.settings),
      tooltip:  'Cancela todos los turnos del día',
      color:    Colors.indigo,
      iconSize: 28,
    ),
  ],
),
const SizedBox(height: 12),

// ── Botones con estilo personalizado ──────────────────────────────────
Wrap(
  spacing: 8, runSpacing: 8,
  children: [
    ElevatedButton(
      onPressed: () {},
      style: ElevatedButton.styleFrom(
        backgroundColor: Colors.red.shade600,
        foregroundColor: Colors.white,
        padding:     const EdgeInsets.symmetric(horizontal: 32, vertical: 14),
        shape: const StadiumBorder(),
        elevation: 0,
      ),
      child: const Text('Urgencia',
          style: TextStyle(fontWeight: FontWeight.bold)),
    ),
    ElevatedButton(
      onPressed: () {},
      style: ElevatedButton.styleFrom(
        backgroundColor: Colors.red.shade600,
        foregroundColor: Colors.white,
        padding:     const EdgeInsets.symmetric(horizontal: 32, vertical: 14),
        shape: const StadiumBorder(),
        elevation: 12,
      ),
      child: const Text('Turno prioritario',
          style: TextStyle(fontWeight: FontWeight.bold)),
    ),
  ],
),
const Divider(height: 32),
// Agrega a children: [ ... ]

Card(
  elevation: 0,
  color: Colors.red.shade50,
  margin: const EdgeInsets.only(bottom: 8),
  shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
  child: ListTile(
    contentPadding: const EdgeInsets.symmetric(horizontal: 20, vertical: 12),
    isThreeLine: true,
    leading:  const Icon(Icons.local_hospital, color: Colors.indigo),
    title:    const Text('Consultorio 1 — Dra. Gómez'),
    subtitle: const Text('Cardiología · turno 09:30 — paciente '
        'ingresado y recibiendo atención en este momento'),
    trailing: const Icon(Icons.circle, color: Colors.green, size: 12),
    onTap:    () {},
  ),
),
Card(
  elevation: 12,
  child: ListTile(
    leading: CircleAvatar(
      backgroundColor: Colors.red.shade100,
      child: const Icon(Icons.cancel, color: Colors.red, size: 20),
    ),
    title:    const Text('Consultorio 4 — Dr. Ramírez'),
    subtitle: const Text('paciente no se presentó · turno 10:15'),
    trailing: TextButton(onPressed: () {}, child: const Text('Ver')),
  ),
),
Card(
  margin: const EdgeInsets.only(top: 8),
  child: SwitchListTile(
    value: false,
    onChanged: (_) {},
    title: const Text('Modo guardia nocturna'),
    secondary: const Icon(Icons.nightlight_round),
  ),
),
const Divider(height: 32),
// Agrega a children: [ ... ]

Wrap(
  spacing: 8, runSpacing: 8,
  children: [
    Chip(
      label: const Text('Cardiología'),
      deleteIcon: const Icon(Icons.close, size: 16),
      onDeleted: () {},
      padding: const EdgeInsets.all(8),
    ),
    Chip(
      avatar:          const Icon(Icons.check, size: 16, color: Colors.white),
      label:           const Text('Obra social vigente'),
      backgroundColor: Colors.blue,
      labelStyle:      const TextStyle(color: Colors.white, fontSize: 12),
      deleteIcon:      const Icon(Icons.close, size: 16),
      onDeleted:       () {},
    ),
    FilterChip(
      label:      const Text('Pediatría'),
      selected:   false,
      onSelected: (_) {},
    ),
    ActionChip(
      label:     const Text('Ver historia clínica'),
      avatar:    const Icon(Icons.open_in_new, size: 16),
      onPressed: () {},
    ),
    InputChip(
      label:     const Text('Alergia a penicilina'),
      avatar:    const Icon(Icons.check_circle, size: 16),
      selected:  false,
      onDeleted: () {},
      onSelected: (_) {},
    ),
  ],
),
const Divider(height: 32),
// Agrega a children: [ ... ]

// ── Circular ──────────────────────────────────────────────────────────
Row(
  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
  children: const [
    SizedBox(width: 48, height: 48,
      child: CircularProgressIndicator()),           // value: null → animación continua
    SizedBox(width: 48, height: 48,
      child: CircularProgressIndicator(
        value:       0.7,           // 70 %
        color:       Colors.green,
        strokeWidth: 6,
      )),
    SizedBox(width: 48, height: 48,
      child: CircularProgressIndicator(
        value:       0.3,
        color:       Colors.red,
        strokeWidth: 3,
        strokeCap:   StrokeCap.round,   // puntas redondeadas
      )),
  ],
),
const SizedBox(height: 16),

// ── Lineal ────────────────────────────────────────────────────────────
const LinearProgressIndicator(),                                  // indeterminado — ocupación en cálculo
const SizedBox(height: 8),
const LinearProgressIndicator(value: 0.6, color: Colors.indigo), // 60 % de camas ocupadas
const SizedBox(height: 8),
const LinearProgressIndicator(
  value:     1.0,
  color:     Colors.green,
  minHeight: 6,                     // barra más gruesa (default: 4)
),
const Divider(height: 32),

// ← pega aquí cada bloque al avanzar
        ],
      ),
    );
  }
}
