class Cita {
  final String id;
  final String paciente;
  final String fecha;
  final String hora;
  final bool   urgente;

  const Cita({
    required this.id,
    required this.paciente,
    required this.fecha,
    required this.hora,
    required this.urgente,
  });
}

// Lista simulada — en una app real vendría de un provider
const citasSimuladas = [
  Cita(id: '1', paciente: 'Juan Pérez',  fecha: '27/07/2026', hora: '09:00', urgente: true),
  Cita(id: '2', paciente: 'María Gómez', fecha: '27/07/2026', hora: '10:30', urgente: false),
  Cita(id: '3', paciente: 'Carlos Ruiz', fecha: '28/07/2026', hora: '11:15', urgente: false),
];
