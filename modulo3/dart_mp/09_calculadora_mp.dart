import 'dart:io';

void main() {
  print('Ingrese el costo base de la consulta:');
  double costoBase = double.parse(stdin.readLineSync()!);
  print('Costo base: \$$costoBase');

  for (int i = 1; i <= 5; i++) {
    print('--- Sesión $i ---');
    print('\$$costoBase x $i = \$${costoBase * i}');
  }
}
