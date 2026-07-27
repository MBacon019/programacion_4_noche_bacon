import 'dart:io';

// async → la función retorna Future<String>
Future<String> obtenerEstadoPaciente() async {
  // await suspende la ejecución hasta que el Future se resuelva
  print('antes');
  await Future.delayed(Duration(milliseconds: 200));  // simula latencia
  print('despues');
  return 'Paciente P-1024 — Hipertensión leve — Activo';
}

// void main también puede ser async
void main() async {
  print('Consultando estado del paciente...');
  final estado = await obtenerEstadoPaciente();
  print('Estado: $estado');
  print('Consulta completada');
}
