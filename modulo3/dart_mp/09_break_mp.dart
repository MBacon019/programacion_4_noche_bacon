void main() {
  final mediciones = [36.8, 37.2, 38.5, -1.0, 37.9, 39.1, -1.0, 38.0];
  //                               ↑              ↑
  //                      medición inválida  medición inválida

  // continue — salta la medición inválida y continúa
  print('=== Procesando con continue ===');
  for (final temp in mediciones) {
    if (temp < 0) {
      print('Medición inválida ignorada');
      continue;  // salta al siguiente
    }
    print('Temperatura registrada: $temp °C');
  }

  // break — detiene al encontrar medición crítica
  print('\n=== Procesando con break ===');
  for (final temp in mediciones) {
    if (temp < 0) {
      print('Error crítico en sensor — deteniendo registro');
      break;  // sale del bucle
    }
    print('Temperatura registrada: $temp °C');
  }
}
