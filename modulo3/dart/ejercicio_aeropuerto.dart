import 'dart:io';

void main() {
  int totalPasajeros = 0;
  int totalMinutosRetraso = 0;
  int totalVuelos = 0;
  int totalAgentes = 0;

  while (true) {
    print('Ingrese la cantidad de vuelos atendidos (0 para salir):');
    String? entradaVuelos = stdin.readLineSync();
    if (entradaVuelos == null) continue;
    int? vuelos = int.tryParse(entradaVuelos);

    if (vuelos == null || vuelos < 0) continue;
    if (vuelos == 0) break;

    print('Ingrese la cantidad de pasajeros procesados:');
    String? entradaPasajeros = stdin.readLineSync();
    if (entradaPasajeros == null) continue;
    int? pasajeros = int.tryParse(entradaPasajeros);

    if (pasajeros == null || pasajeros < 0) continue;

    print('Ingrese los minutos totales de retraso:');
    String? entradaRetraso = stdin.readLineSync();
    if (entradaRetraso == null) continue;
    int? minutosRetraso = int.tryParse(entradaRetraso);

    if (minutosRetraso == null || minutosRetraso < 0) continue;

    double pasajerosPorVuelo = pasajeros / vuelos;
    double retrasoPorVuelo = minutosRetraso / vuelos;

    if (pasajerosPorVuelo < 50) {
      print('Baja eficiencia');
    } else if (pasajerosPorVuelo >= 50 && pasajerosPorVuelo <= 120) {
      print('Eficiencia normal');
    } else {
      print('Alta eficiencia');
    }

    totalPasajeros += pasajeros;
    totalMinutosRetraso += minutosRetraso;
    totalVuelos += vuelos;
    totalAgentes++;
  }

  print('Reporte Final');
  print('Total de pasajeros procesados: $totalPasajeros');
  print('Total de minutos de retraso acumulados: $totalMinutosRetraso');
  print('Cantidad de agentes registrados: $totalAgentes');

  if (totalAgentes > 0) {
    double promedioPasajerosAgente = totalPasajeros / totalAgentes;
    print('Promedio de pasajeros por agente: ${promedioPasajerosAgente.toStringAsFixed(2)}');
  } else {
    print('Promedio de pasajeros por agente: 0.00');
  }

  if (totalVuelos > 0) {
    double promedioRetrasoVuelo = totalMinutosRetraso / totalVuelos;
    print('Promedio general de retraso por vuelo: ${promedioRetrasoVuelo.toStringAsFixed(2)}');
  } else {
    print('Promedio general de retraso por vuelo: 0.00');
  }
}