import 'dart:io';

void  main() {
  print('Ingrese su nombre:');
  String? nombre = stdin.readLineSync();
  print('Hola $nombre');

  print('Ingrese un nùmero entero:');
  int numero = int.parse(stdin.readLineSync()!);
  print('Nùmero: $numero');

  print('Ingrese un decimal:');
  double valor = double.parse(stdin.readLineSync()!);
  print('Valor: $valor');

}                                         