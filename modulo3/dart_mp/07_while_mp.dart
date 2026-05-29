void main() {
  // while — tomar mediciones de presión arterial
  int medicionesRestantes = 4;
  int totalPresion        = 0;

  while (medicionesRestantes > 0) {
    int presion = 120 + (4 - medicionesRestantes) * 5;  // simulación
    totalPresion += presion;
    medicionesRestantes--;
    print('Medición tomada: $presion mmHg (restantes: $medicionesRestantes)');
  }

  print('Presión promedio: ${totalPresion ~/ 4} mmHg');

  // do-while — reintentar conexión con sistema hospitalario
  int reintentos               = 0;
  bool conexionEstablecida     = false;

  do {
    reintentos++;
    print('Conectando al sistema hospitalario — intento #$reintentos...');
    if (reintentos == 3) conexionEstablecida = true;
  } while (!conexionEstablecida && reintentos < 5);

  print(conexionEstablecida
      ? 'Conectado al sistema tras $reintentos intentos'
      : 'No se pudo conectar al sistema hospitalario');
}
