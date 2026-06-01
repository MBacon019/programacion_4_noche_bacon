void main() {
  // === 1. VARIABLES BÁSICAS Y TIPOS ===
  var nombrePaciente = 'Carlos';       // String
  var edadPaciente   = 45;             // int
  var costoConsulta  = 80.0;           // double
  var tieneSeguro    = true;           // bool

  // Tipo explícito
  String apellidoPaciente = 'Ruiz';
  int    numeroCita       = 1024;
  double temperatura      = 37.5;
  bool   hospitalizado    = false;

  print('$nombrePaciente $apellidoPaciente tiene $edadPaciente años. Cita: $numeroCita, Seguro: $tieneSeguro');


  // === 2. FINAL VS CONST ===
  // final — no se puede reasignar
  final especialidad = 'Cardiologia';
  // especialidad = 'Neurologia';  // ERROR — final no se puede reasignar

  // const — constante en tiempo de compilación
  const temperaturaFebril  = 38.0;
  const temperaturaNormal  = 36.5;

  // Diferencia clave: final vs const
  final fechaConsulta = DateTime.now();   // OK — se evalúa en runtime
  // const fechaConsulta = DateTime.now(); // ERROR

  print('Fiebre desde: $temperaturaFebril°C, Normal: $temperaturaNormal°C, Fecha: $fechaConsulta');


  // === 3. MUTABILIDAD ===
  var turnoEspera = 0;
  turnoEspera = 1;          // OK

  final diagnosticos = ['Hipertension', 'Diabetes'];
  diagnosticos.add('Asma');  // OK — la referencia es final, no el contenido
  // diagnosticos = [];      // ERROR

  const gruposSanguineos = ['A', 'B', 'AB', 'O'];
  // gruposSanguineos.add('X'); // ERROR — const es completamente inmutable


  // === 4. NULL SAFETY ===
  String nombreMedico = 'Dra. Laura';
  // nombreMedico = null;  // ERROR de compilación

  String? diagnosticoNullable = null;   // OK
  diagnosticoNullable = 'Hipertension leve';

  String? sala;

  // ?. — safe call
  print(sala?.length);      // null — no lanza excepción

  // ?? — operador Elvis
  String salaAsignada = sala ?? 'Sin sala asignada';
  print(salaAsignada);      // Sin sala asignada

  // Null check con if
  if (diagnosticoNullable != null) {
    print(diagnosticoNullable.length);  // smart cast — seguro aquí
  }


  // === 5. LATE (Inicialización diferida) ===
  late String numeroHistoriaClinica;
  numeroHistoriaClinica = 'HC-2024-00123';
  print(numeroHistoriaClinica);
}
