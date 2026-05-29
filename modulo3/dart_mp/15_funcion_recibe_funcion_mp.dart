// Tipo explícito del parámetro función: bool Function(double)
List<double> filtrarConsultas(List<double> lista, bool Function(double) criterio) {
  return lista.where(criterio).toList();
}

bool tieneFiebre(double temp)     => temp >= 38.0;
bool esCritico(double temp)       => temp > 39.5;

void main() {
  final temperaturas = [36.5, 38.2, 37.0, 39.8, 38.7, 36.9, 40.1, 37.5];

  print(filtrarConsultas(temperaturas, tieneFiebre));   // [38.2, 39.8, 38.7, 40.1]
  print(filtrarConsultas(temperaturas, esCritico));     // [39.8, 40.1]

  // Lambda en línea como argumento
  print(filtrarConsultas(temperaturas, (t) => t >= 36.0 && t < 38.0));  // normales
}
