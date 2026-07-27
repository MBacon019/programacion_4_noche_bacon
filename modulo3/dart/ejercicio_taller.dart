import 'dart:io';

void main() {
  int totalTablas = 0;
  int totalOperarios = 0;
  bool continuar = true;

  while (continuar) {
    print('Ingrese la cantidad de tablas cortadas por el operario (0 para salir):');
    String? entrada = stdin.readLineSync();
    
    if (entrada == null) continue;
    
    int? tablas = int.tryParse(entrada);

    if (tablas == null || tablas < 0) {
      print('Por favor, ingrese un número válido.');
      continue;
    }

    if (tablas == 0) {
      continuar = false;
    } else {
      if (tablas < 15) {
        print('Trabajo lento');
      } else if (tablas >= 15 && tablas <= 40) {
        print('Trabajo eficiente');
      } else {
        print('Trabajo sobresaliente');
      }

      totalTablas += tablas;
      totalOperarios++;
    }
  }

  print('Reporte Final');
  print('Total de tablas cortadas: $totalTablas');
  print('Cantidad de operarios registrados: $totalOperarios');

  if (totalOperarios > 0) {
    double promedio = totalTablas / totalOperarios;
    print('Promedio de tablas por operario: ${promedio.toStringAsFixed(2)}');
  } else {
    print('Promedio de tablas por operario: 0.00');
  }
}