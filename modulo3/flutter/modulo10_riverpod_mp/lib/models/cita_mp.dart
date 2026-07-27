class Cita {
  final String id;
  final String paciente;
  final String fecha;
  final String hora;
  final bool   urgente;
  bool         confirmada;

  Cita({
    required this.id,
    required this.paciente,
    required this.fecha,
    required this.hora,
    required this.urgente,
    this.confirmada = false,
  });
}
