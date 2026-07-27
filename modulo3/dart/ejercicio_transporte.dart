import 'dart:io';

void main() {
  while (true) {
    print('¿Desea registrar un conductor? (si/no):');
    String? continuar = stdin.readLineSync();
    if (continuar == null || continuar.toLowerCase() != 'si') break;

    double totalKilometros = 0;

    for (int i = 1; i <= 5; i++) {
      print('Ingrese los kilómetros del viaje $i:');
      String? entradaKm = stdin.readLineSync();
      if (entradaKm == null) continue;
      double? kmViaje = double.tryParse(entradaKm);

      if (kmViaje == null || kmViaje < 0) {
        i--;
        continue;
      }

      if (kmViaje < 50) {
        print('Ruta corta');
      } else if (kmViaje >= 50 && kmViaje <= 150) {
        print('Ruta media');
      } else {
        print('Ruta larga');
      }

      totalKilometros += kmViaje;
    }

    double totalCombustible = totalKilometros / 12;
    double promedioKilometros = totalKilometros / 5;

    print('Reporte del Conductor');
    print('Total de kilómetros recorridos: ${totalKilometros.toStringAsFixed(2)} km');
    print('Total de combustible estimado: ${totalCombustible.toStringAsFixed(2)} litros');
    print('Promedio de kilómetros por viaje: ${promedioKilometros.toStringAsFixed(2)} km\n');
  }
}