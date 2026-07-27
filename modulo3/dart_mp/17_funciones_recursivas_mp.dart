// Dosis total — caso base y caso recursivo
double dosisTotal(int dias, double dosisDiaria) {
  if (dias <= 0) return 0;              // caso base
  return dosisDiaria + dosisTotal(dias - 1, dosisDiaria); // llamada recursiva
}

// Fibonacci — para calcular turnos de espera simulados
int turnoEspera(int n) {
  if (n <= 1) return n;
  return turnoEspera(n - 1) + turnoEspera(n - 2);
}

// Búsqueda en árbol de expedientes (simulado)
int contarConsultas(Map<String, dynamic> expediente) {
  int total = 0;
  for (final entrada in expediente.entries) {
    if (entrada.value is Map) {
      // Es una carpeta de especialidad — llamada recursiva
      total += contarConsultas(entrada.value as Map<String, dynamic>);
    } else {
      total++;  // Es una consulta
    }
  }
  return total;
}

void main() {
  print(dosisTotal(7, 500));    // 3500.0  (500mg/día × 7 días)
  print(turnoEspera(10));       // 55

  final expedienteClinico = {
    'cardiologia': {
      'consultas': {'c001.json': true, 'c002.json': true},
      'examenes':  {'ecg_001.pdf': true},
    },
    'neurologia': {
      'consultas': {'c003.json': true, 'c004.json': true},
      'imagenes':  {'rm_001.pdf': true, 'tc_001.pdf': true},
    },
    'resumen_clinico.pdf': true,
    'consentimiento.pdf':  true,
  };

  print('Total de registros: ${contarConsultas(expedienteClinico)}');  // 10
}
