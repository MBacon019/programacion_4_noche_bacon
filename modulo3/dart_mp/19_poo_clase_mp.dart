class MonitorPaciente {
  // 1. Propiedades
  final String id;
  final String nombrePaciente;
  String       sala;
  bool         _activo = false;  // _ indica uso interno

  // 2. Constructor nombrado con parámetros nombrados
  MonitorPaciente({
    required this.id,
    required this.nombrePaciente,
    required this.sala,
  });

  // 3. Getter — propiedad derivada, solo lectura
  bool   get activo  => _activo;
  String get estado  => _activo ? 'monitoreando' : 'inactivo';

  // 4. Setter — escritura controlada
  set estadoMonitor(bool valor) {
    _activo = valor;
    print('$nombrePaciente ($id): ${valor ? "monitoreo iniciado" : "monitoreo detenido"}');
  }

  // 5. Métodos
  void conectar() {
    _activo = true;
    print('$nombrePaciente conectado en sala $sala');
  }

  void desconectar() {
    _activo = false;
    print('$nombrePaciente desconectado del monitor');
  }

  String resumen() => 'ID: $id | Paciente: $nombrePaciente | Sala: $sala | Estado: $estado';

  // 6. toString
  @override
  String toString() => 'MonitorPaciente($nombrePaciente, $sala, $estado)';
}

void main() {
  // Crear una instancia
  final monitor = MonitorPaciente(
    id:              'MON-001',
    nombrePaciente:  'Carlos Ruiz',
    sala:            'UCI-3',
  );

  // Usar sus métodos y propiedades
  monitor.conectar();
  print(monitor.estado);       // monitoreando
  print(monitor.resumen());
  print(monitor);              // llama toString() automáticamente

  monitor.estadoMonitor = false;  // usa el setter
  print(monitor.activo);      // false
}
