// Fábrica de ajustadores de dosis — devuelve una función configurada
double Function(double) crearAjustadorDosis(double factor) {
  return (double dosis) => dosis * factor;
}

void main() {
  final dosisDoble    = crearAjustadorDosis(2);
  final dosisTriple   = crearAjustadorDosis(3);
  final dosisReducida = crearAjustadorDosis(0.5);

  print(dosisDoble(250));    // 500.0
  print(dosisTriple(250));   // 750.0
  print(dosisReducida(250)); // 125.0

  // Útil para generar validadores de signos vitales configurables
  bool Function(double) crearValidadorPresion(double min, double max) {
    return (presion) => presion >= min && presion <= max;
  }

  final esNormal        = crearValidadorPresion(60, 120);
  final esHipertenso    = crearValidadorPresion(140, double.infinity);

  print(esNormal(110.0));       // true
  print(esHipertenso(155.0));   // true
  print(esHipertenso(110.0));   // false
}
