void main() {
  // Forma básica
  double temperatura = 38.7;

  if (temperatura >= 40.0) {
    print('Fiebre alta — urgencia inmediata');
  } else if (temperatura >= 38.0) {
    print('Fiebre — requiere atención médica');
  } else if (temperatura >= 36.0) {
    print('Normal');
  } else {
    print('Hipotermia');
  }

  // Operador ternario — para decisiones de una línea
  String estadoFiebre = temperatura >= 38.0 ? 'Con fiebre' : 'Sin fiebre';
  print(estadoFiebre);

  // null-aware con ternario
  String? sala;
  String displaySala = sala != null ? sala.toUpperCase() : 'Sin sala asignada';

  // Forma más concisa con ??
  String displaySala2 = sala?.toUpperCase() ?? 'Sin sala asignada';
  print(displaySala2);  // Sin sala asignada
}
