class SistemaClinico {
  final String nombreClinica;
  final String ip;
  final int    puerto;
  final bool   usaSsl;

  // Constructor principal
  SistemaClinico({
    required this.nombreClinica,
    required this.ip,
    required this.puerto,
    this.usaSsl = false,
  });

  // Constructor nombrado — sistema local de pruebas
  SistemaClinico.local()
      : nombreClinica = 'clinica-local',
        ip            = '127.0.0.1',
        puerto        = 8080,
        usaSsl        = false;

  SistemaClinico.produccion({required this.nombreClinica, required this.ip})
      : puerto  = 443,
        usaSsl  = true;

  // Constructor factory — lógica de creación más compleja
  factory SistemaClinico.desdeUrl(String url) {
    final uri = Uri.parse(url);
    return SistemaClinico(
      nombreClinica: uri.host,
      ip:            uri.host,        // simplificado para el ejemplo
      puerto:        uri.port != 0 ? uri.port : (uri.scheme == 'https' ? 443 : 80),
      usaSsl:        uri.scheme == 'https',
    );
  }

  @override
  String toString() =>
      '${usaSsl ? "https" : "http"}://$nombreClinica:$puerto';
}

void main() {
  final s1 = SistemaClinico(nombreClinica: 'clinica-san-rafael', ip: '10.0.1.5', puerto: 3000);
  final s2 = SistemaClinico.local();
  final s3 = SistemaClinico.produccion(nombreClinica: 'clinica-san-rafael', ip: '10.0.1.5');
  final s4 = SistemaClinico.desdeUrl('https://expedientes.clinica.com:8443/v1');

  print(s1);  // http://clinica-san-rafael:3000
  print(s2);  // http://clinica-local:8080
  print(s3);  // https://clinica-san-rafael:443
  print(s4);  // https://expedientes.clinica.com:8443
}
