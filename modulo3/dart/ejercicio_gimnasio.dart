import 'dart:io';

void main() {
  int totalMinutos = 0;
  int totalClientes = 0;

  while (true) {
    print('Ingrese los minutos de entrenamiento (0 para salir):');
    String? entrada = stdin.readLineSync();
    if (entrada == null) continue;
    int? minutos = int.tryParse(entrada);

    if (minutos == null || minutos < 0) continue;
    if (minutos == 0) break;

    if (minutos < 30) {
      print('Entrenamiento insuficiente');
    } else if (minutos >= 30 && minutos <= 90) {
      print('Entrenamiento adecuado');
    } else {
      print('Entrenamiento intenso');
    }

    totalMinutos += minutos;
    totalClientes++;
  }

  print('Reporte Final ');
  print('Total de minutos entrenados: $totalMinutos');
  print('Cantidad de clientes registrados: $totalClientes');

  if (totalClientes > 0) {
    double promedio = totalMinutos / totalClientes;
    print('Promedio de minutos por cliente: ${promedio.toStringAsFixed(2)}');
  } else {
    print('Promedio de minutos por cliente: 0.00');
  }
}