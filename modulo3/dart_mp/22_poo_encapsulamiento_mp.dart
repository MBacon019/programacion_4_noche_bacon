class HistorialCitas {
  final String paciente;
  double _saldo;  // privado — nadie lo modifica directamente

  HistorialCitas(this.paciente, double saldoInicial)
      : _saldo = saldoInicial;

  // Getter — lectura permitida, escritura no
  double get saldo => _saldo;

  // Los únicos caminos para modificar _saldo
  void agendarCita(double costo) {
    if (costo <= 0) throw ArgumentError('El costo debe ser positivo');
    _saldo += costo;
    print('Cita agendada por \$$costo. Total acumulado: \$$_saldo');
  }

  void cancelarCita(double costo) {
    if (costo <= 0)       throw ArgumentError('El costo debe ser positivo');
    if (costo > _saldo)   throw StateError('No hay saldo acumulado suficiente');
    _saldo -= costo;
    print('Cita cancelada por \$$costo. Total acumulado: \$$_saldo');
  }
}

void main() {
  final historial = HistorialCitas('Ana López', 0.0);

  historial.agendarCita(80.0);   // Cita agendada por $80.0.  Total acumulado: $80.0
  historial.agendarCita(150.0);  // Cita agendada por $150.0. Total acumulado: $230.0
  historial.cancelarCita(80.0);  // Cita cancelada por $80.0. Total acumulado: $150.0
  print(historial.saldo);        // 150.0

  // historial._saldo = 0;  // ERROR — privado, Dart no lo permite
}
