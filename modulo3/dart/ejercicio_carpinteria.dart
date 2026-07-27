import 'dart:io';

void main() {
  int totalMuebles = 0;
  int trabajadores = 0;

  while (true) {
    stdout.write('Ingrese cantidad de muebles: ');
    int muebles = int.parse(stdin.readLineSync()!);

    if (muebles == 0) {
      break;
    }

    if (muebles < 3) {
      print('"Producción baja"');
    } else if (muebles <= 7) {
      print('"Producción normal"');
    } else {
      print('"Producción alta"');                             
    }

    totalMuebles += muebles;
    trabajadores++;
  }

  print('Total de muebles fabricados: $totalMuebles');
  print('Cantidad de trabajadores registrados: $trabajadores');
  
  if (trabajadores > 0) {
    print('Promedio de muebles por trabajador: ${totalMuebles / trabajadores}');
  } else {
    print('Promedio de muebles por trabajador: 0');
  }
}