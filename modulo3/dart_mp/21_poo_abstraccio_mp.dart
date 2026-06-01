// abstract class define el contrato — QUÉ puede hacer cualquier ProcedimientoMedico
abstract class ProcedimientoMedico {
  String get nombre;
  double calcularCosto();      // cada procedimiento lo implementa a su manera
  int    calcularDuracion();

  // Método concreto construido sobre la abstracción
  void describir() {
    print('$nombre — costo: \$${calcularCosto().toStringAsFixed(2)}, '
          'duración: ${calcularDuracion()} min');
  }
}

// Implementaciones concretas — el CÓMO es específico de cada clase
class ConsultaMedica extends ProcedimientoMedico {
  final String especialidad;
  ConsultaMedica(this.especialidad);

  @override String get nombre          => 'Consulta ($especialidad)';
  @override double calcularCosto()     => 80.0;
  @override int    calcularDuracion()  => 30;
}

class ExamenLaboratorio extends ProcedimientoMedico {
  final int cantidadPruebas;
  ExamenLaboratorio(this.cantidadPruebas);

  @override String get nombre          => 'Examen de laboratorio';
  @override double calcularCosto()     => cantidadPruebas * 25.0;
  @override int    calcularDuracion()  => cantidadPruebas * 10;
}

void main() {
  final procedimientos = <ProcedimientoMedico>[
    ConsultaMedica('Cardiología'),
    ExamenLaboratorio(4),
  ];
  for (final p in procedimientos) {
    p.describir();  // no importa qué tipo de ProcedimientoMedico es
  }
}
