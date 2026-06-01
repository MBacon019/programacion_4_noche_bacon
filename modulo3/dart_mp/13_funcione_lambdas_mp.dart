void main() {
  // Lambda asignada a una variable
  final calcularImc = (double peso, double talla) => peso / (talla * talla);
  print(calcularImc(70, 1.70).toStringAsFixed(2));  // 24.22

  // Lambda de cuerpo completo
  final calcularDescuentoConsulta = (double costo, double pct) {
    final descuento = costo * (pct / 100);
    return costo - descuento;
  };
  print(calcularDescuentoConsulta(100.0, 15.0));  // 85.0

  // Lambda en línea — pasada directamente como argumento
  final costos = [80.0, 150.0, 50.0, 200.0, 90.0, 120.0];
  costos.sort((a, b) => b.compareTo(a));  // orden descendente
  print(costos);  // [200.0, 150.0, 120.0, 90.0, 80.0, 50.0]
}
