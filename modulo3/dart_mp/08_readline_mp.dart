import 'dart:io';

void main() {
  print('Ingrese el nombre del paciente:');
  String? nombrePaciente = stdin.readLineSync();
  print('Paciente registrado: $nombrePaciente');

  print('Ingrese el número de cita:');
  int numeroCita = int.parse(stdin.readLineSync()!);
  print('Número de cita: $numeroCita');

  print('Ingrese la temperatura corporal (°C):');
  double temperatura = double.parse(stdin.readLineSync()!);
  print('Temperatura: $temperatura °C');
}
