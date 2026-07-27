void registrarConsulta() {
  print('Consulta médica registrada en el sistema');
}

void saludarPaciente(String nombre) {
  print('Bienvenido al consultorio, $nombre');
}

int obtenerTurno() {
  return 305;
}

double calcularTotal(double costoConsulta, double costoMedicamento) {
  return costoConsulta + costoMedicamento;
}

double aplicarDescuento(double costoBase, double porcentaje) =>
    costoBase - (costoBase * porcentaje / 100);

void saludarConEspecialidad(String nombre, [String especialidad = 'Medicina General']) {
  print('Paciente $nombre — Especialidad: $especialidad');
}

// Función con parámetros nombrados
void agendarCita({
  required String nombrePaciente,
  required String especialidad,
}) {
  print('Cita agendada: $nombrePaciente → $especialidad');
}

void main() {
  registrarConsulta();
  saludarPaciente('Ana Torres');
  int turno = obtenerTurno();
  print(turno);
  print('Turno asignado: ${obtenerTurno()}');
  print('Total consulta: \$${calcularTotal(80.0, 30.0)}');
  print('Con descuento 10%: \$${aplicarDescuento(80.0, 10)}');
  saludarConEspecialidad('Carlos Ruiz', 'Cardiología');
  saludarConEspecialidad('María López');
  agendarCita(nombrePaciente: 'Pedro Gómez', especialidad: 'Neurología');
}
