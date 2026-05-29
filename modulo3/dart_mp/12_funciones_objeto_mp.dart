double duplicarDosis(double dosis)    => dosis * 2;
double triplicarDosis(double dosis)   => dosis * 3;

void main() {
  // La variable 'aplicarDosis' tiene tipo: double Function(double)
  double Function(double) aplicarDosis;

  aplicarDosis = duplicarDosis;
  print(aplicarDosis(250));     // 500.0

  aplicarDosis = triplicarDosis;
  print(aplicarDosis(250));     // 750.0

  // Lista de funciones
  final ajustes = <double Function(double)>[duplicarDosis, triplicarDosis];
  for (final fn in ajustes) {
    print(fn(100));         // 200.0, luego 300.0
  }
}
