void main() {
  // for con índice — recorrer turnos de consulta
  for (int i = 0; i < 5; i++) {
    print('Turno de consulta $i');
  }

  // for con paso distinto — progreso de recuperación
  for (int i = 0; i <= 100; i += 25) {
    print('Recuperación del paciente: $i%');
  }

  // for decreciente — cuenta regresiva para procedimiento
  for (int i = 5; i >= 1; i--) {
    print('Inicio del procedimiento en: $i');
  }
}
