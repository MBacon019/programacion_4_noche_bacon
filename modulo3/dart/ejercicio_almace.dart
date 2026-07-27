import 'dart:io';

void main() {
  while (true) {
    print('¿Desea registrar un vendedor? (si/no):');
    String? continuar = stdin.readLineSync();
    if (continuar == null || continuar.toLowerCase() != 'si') break;

    int totalVentasVendedor = 0;

    for (int i = 1; i <= 7; i++) {
      print('Ingrese las ventas del día $i:');
      String? entradaVentas = stdin.readLineSync();
      if (entradaVentas == null) continue;
      int? ventasDia = int.tryParse(entradaVentas);

      if (ventasDia == null || ventasDia < 0) {
        i--; 
        continue;
      }

      totalVentasVendedor += ventasDia;
    }

    double promedioDiario = totalVentasVendedor / 7;
    String rendimiento = '';

    if (promedioDiario < 10) {
      rendimiento = 'Bajo rendimiento';
    } else if (promedioDiario >= 10 && promedioDiario <= 25) {
      rendimiento = 'Rendimiento normal';
    } else {
      rendimiento = 'Alto rendimiento';
    }

    print('Reporte del Vendedor');
    print('Total de ventas: $totalVentasVendedor');
    print('Promedio de ventas: ${promedioDiario.toStringAsFixed(2)}');
    print('Clasificación de rendimiento: $rendimiento\n');
  }
}