import 'dart:io';

void main() {
  double costoConsulta = -1;
  double totalFacturado = 0;

  while (costoConsulta != 0) {
    print('Ingrese el costo de la consulta (0 para finalizar):');
    costoConsulta = double.parse(stdin.readLineSync()!);

    if (costoConsulta != 0) {
      totalFacturado += costoConsulta;
      print('Consulta registrada: \$$costoConsulta');
    }
  }

  print('Total facturado: \$$totalFacturado');
  print('Proceso de facturación finalizado.');
}
