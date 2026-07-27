// lib/models/cita_mp.dart
class Cita {
  final String id;
  final String paciente;
  final String especialidad;
  final String fecha;
  final String hora;
  final String medico;
  final bool   urgente;
  bool         confirmada;  // mutable — puede cambiar sin recrear el objeto

  Cita({
    required this.id,
    required this.paciente,
    required this.especialidad,
    required this.fecha,
    required this.hora,
    required this.medico,
    required this.urgente,
    this.confirmada = false,
  });
}
