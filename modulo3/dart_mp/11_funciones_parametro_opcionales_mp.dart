// El tercer parámetro es opcional — puede omitirse al llamar
String construirUrlConsulta(String host, String ruta, [int? puerto]) {
  if (puerto != null) {
    return 'https://$host:$puerto$ruta';
  }
  return 'https://$host$ruta';
}

// Con valor por defecto — evita el chequeo de null
String construirUrlConsultaV2(String host, String ruta, [int puerto = 443]) {
  return 'https://$host:$puerto$ruta';
}

// required → el parámetro es obligatorio
// sin required → es opcional (necesita valor por defecto o ser nullable)
void configurarSistemaHospitalario({
  required String host,
  required int    puerto,
  bool   ssl        = true,
  int    timeoutSeg = 30,
}) {
  final protocolo = ssl ? 'https' : 'http';
  print('Conectando al sistema hospitalario: $protocolo://$host:$puerto (timeout: ${timeoutSeg}s)');
}

void main() {
  print(construirUrlConsulta('clinica.hospital.com', '/pacientes'));           // https://clinica.hospital.com/pacientes
  print(construirUrlConsulta('clinica.hospital.com', '/consultas', 8080));    // https://clinica.hospital.com:8080/consultas
  print(construirUrlConsultaV2('clinica.hospital.com', '/expedientes'));

  // Los nombrados pueden pasarse en cualquier orden
  configurarSistemaHospitalario(
    host:       'db.hospital.com',
    puerto:     5432,
    ssl:        false,
    timeoutSeg: 60,
  );

  // Solo los obligatorios — los opcionales toman su valor por defecto
  configurarSistemaHospitalario(
    host:   'api.hospital.com',
    puerto: 443,
  );
}      // https://clinica.hospital.com:443/expedientes
