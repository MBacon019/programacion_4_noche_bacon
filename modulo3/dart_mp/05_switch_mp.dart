void main() {
  String grupoSanguineo = 'AB';

  switch (grupoSanguineo) {
    case 'A':
      print('Grupo A — dona a A y AB, recibe de A y O');
    case 'B':
      print('Grupo B — dona a B y AB, recibe de B y O');
    case 'AB':
      print('Grupo AB — receptor universal, dona solo a AB');
    case 'O':
      print('Grupo O — donante universal, recibe solo de O');
    default:
      print('Grupo sanguíneo desconocido');
  }

  grupoSanguineo = 'O';

  String descripcionGrupo = switch (grupoSanguineo) {
    'A'  => 'Grupo A — compatible con A y AB',
    'B'  => 'Grupo B — compatible con B y AB',
    'AB' => 'Grupo AB — receptor universal',
    'O'  => 'Grupo O — donante universal',
    _    => 'Grupo sanguíneo no registrado',
  };

  print(descripcionGrupo);  // Grupo O — donante universal

  int nivelAlerta = 2;

  // Múltiples valores en una rama con ||
  String prioridad = switch (nivelAlerta) {
    1 || 2             => 'Nivel bajo — consulta programada',
    3 || 4             => 'Nivel medio — atención preferencial',
    5 || 6 || 7        => 'Nivel alto — atención urgente',
    8 || 9 || 10       => 'Nivel crítico — emergencia inmediata',
    _                  => 'Nivel no reconocido',
  };

  print(prioridad);  // Nivel bajo — consulta programada

  // Guards — condición adicional con 'when'
  double temperatura = 39.2;

  String alerta = switch (temperatura) {
    double t when t >= 40.0 => '🚨 CRÍTICO — llame a emergencias',
    double t when t >= 38.5 => '🔴 FIEBRE ALTA — consulte médico',
    double t when t >= 38.0 => '🟡 FIEBRE LEVE — descanse',
    double t when t >= 36.0 => '🟢 NORMAL',
    _                       => '🔵 HIPOTERMIA — abrígese',
  };

  print(alerta);  // 🔴 FIEBRE ALTA — consulte médico

  // switch puede verificar el TIPO del valor
  Object respuestaExpediente = {'id': 1, 'paciente': 'Carlos Ruiz', 'diagnostico': 'Hipertension'};

  String resultado = switch (respuestaExpediente) {
    Map<String, dynamic> m when m.containsKey('error') =>
        'Error: ${m['error']}',
    Map<String, dynamic> m =>
        'Paciente: ${m['paciente']} — Dx: ${m['diagnostico']}',
    List<dynamic> lista =>
        '${lista.length} registros encontrados',
    String texto =>
        'Mensaje del sistema: $texto',
    _ =>
        'Respuesta desconocida',
  };

  print(resultado);  // Paciente: Carlos Ruiz — Dx: Hipertension
}
