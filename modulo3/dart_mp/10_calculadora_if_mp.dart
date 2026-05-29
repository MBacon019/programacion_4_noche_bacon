import 'dart:io';

void main() {
  print('Ingrese la temperatura corporal del paciente (°C): ');
  double temperatura = double.parse(stdin.readLineSync()!);
  print('Temperatura: $temperatura °C');

  if (temperatura >= 40.0) {
    print('La temperatura $temperatura °C indica FIEBRE ALTA — urgencia inmediata');
  } else if (temperatura >= 38.0) {
    print('La temperatura $temperatura °C indica FIEBRE — requiere atención');
  } else if (temperatura >= 36.0) {
    print('La temperatura $temperatura °C es NORMAL');
  } else {
    print('La temperatura $temperatura °C indica HIPOTERMIA');
  }
}
