import 'dart:io';

void main() {
  int totalPacientes = 0;
  int totalDoctores = 0;

  while (true) {
    print('Ingrese las horas trabajadas (0 para salir):');
    String? entradaHoras = stdin.readLineSync();
    if (entradaHoras == null) continue;
    int? horas = int.tryParse(entradaHoras);

    if (horas == null || horas < 0) continue;
    if (horas == 0) break;

    print('Ingrese la cantidad de pacientes atendidos:');
    String? entradaPacientes = stdin.readLineSync();
    if (entradaPacientes == null) continue;
    int? pacientes = int.tryParse(entradaPacientes);

    if (pacientes == null || pacientes < 0) continue;

    double pacientesPorHora = pacientes / horas;

    if (pacientesPorHora < 3) {
      print('Atención lenta');
    } else if (pacientesPorHora >= 3 && pacientesPorHora <= 6) {
      print('Atención normal');
    } else {
      print('Atención rápida');
    }

    totalPacientes += pacientes;
    totalDoctores++;
  }

  print('Reporte Final');
  print('Total de pacientes atendidos: $totalPacientes');
  print('Cantidad de doctores registrados: $totalDoctores');

  if (totalDoctores > 0) {
    double promedio = totalPacientes / totalDoctores;
    print('Promedio de pacientes por doctor: ${promedio.toStringAsFixed(2)}');
  } else {
    print('Promedio de pacientes por doctor: 0.00');
  }
}