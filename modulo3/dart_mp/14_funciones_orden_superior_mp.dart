void main() {
  final costos = [80.0, 50.0, 120.0, 200.0];

  // map devuelve un Iterable con cada elemento transformado
  final costosConIva = costos.map((c) => c * 1.19);
  print(costosConIva.toList());
  // [95.2, 59.5, 142.8, 238.0]

  // map sobre Strings
  final rutas = ['/pacientes', '/consultas', '/expedientes'];
  final urls  = rutas.map((r) => 'https://api.hospital.com$r');
  print(urls.toList());
  // [https://api.hospital.com/pacientes, ...]


// Temperatura:
    final temperaturas = [36.1, 37.8, 39.2, 36.5, 38.7, 35.9];

  final conFiebre = temperaturas.where((t) => t > 37.5);
  print(conFiebre.toList());  // [37.8, 39.2, 38.7]

  final normales = temperaturas.where((t) => t >= 36.0 && t <= 37.5);
  print(normales.toList());   // [36.1, 36.5]


// Facturación:
    final facturacion = [1500.0, 2300.0, 980.0, 3100.0, 750.0];

  // reduce — combina todos los elementos en uno
  final total = facturacion.reduce((acum, pago) => acum + pago);
  print('Total: \$${total.toStringAsFixed(2)}');  // Total: $8630.00

  // fold — como reduce pero con valor inicial (más seguro con listas vacías)
  final totalFold = facturacion.fold(0.0, (acum, pago) => acum + pago);
  print('Total (fold): \$${totalFold.toStringAsFixed(2)}');

  // Encontrar el máximo
  final maximo = facturacion.reduce((a, b) => a > b ? a : b);
  print('Mayor factura: \$$maximo');  // Mayor factura: $3100.0
}
