void main() {
  final nombrePaciente = 'Carlos';
  final edadPaciente   = 45;

  // Interpolación con $
  print('Paciente: $nombrePaciente');                              // Paciente: Carlos

  // Expresión con ${ }
  print('${nombrePaciente.toUpperCase()} tiene ${edadPaciente + 1} años el próximo año');

  // String multilinea con triple comillas
  final fichaClinica = '''
Paciente:    $nombrePaciente
Edad:        $edadPaciente
Mayor edad:  ${edadPaciente >= 18 ? 'Sí' : 'No'}
  ''';
  print(fichaClinica);

  // Raw string — ignora el escape y la interpolación
  final rutaExpediente = r'C:\Clinica\Expedientes\Pacientes';
  print(rutaExpediente);

  // Concatenación (menos idiomático — preferir interpolación)
  final saludo = 'Bienvenido, ' + nombrePaciente + '!';

  // Métodos útiles de String
  print('cardiologia'.toUpperCase());                  // CARDIOLOGIA
  print('  Dr. Rivera  '.trim());                      // Dr. Rivera
  print('Consulta General'.contains('General'));       // true
  print('Consulta General'.replaceAll('a', 'A'));      // ConsultA GenerAl
  print('A,B,AB,O'.split(','));                        // [A, B, AB, O]
  print('Cardiologia'.substring(0, 6));                // Cardio
  print('Cardiologia'.startsWith('Car'));              // true
  print('001'.padLeft(5, '0'));                        // 00001
}
