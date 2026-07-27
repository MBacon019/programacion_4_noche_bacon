void main() {
  // Conversiones numéricas
  int    numeroCita  = 1024;
  double costoDouble = numeroCita.toDouble();  // 1024.0
  String codigoTexto = numeroCita.toString();  // "1024"

  // String → número
  int    turno       = int.parse('305');        // 305
  double temperatura = double.parse('37.5');    // 37.5

  // Conversión segura (no lanza excepción)
  int?    citaInvalida  = int.tryParse('HC-001');  // null
  double? tempValida    = double.tryParse('38.2'); // 38.2

  // Verificar tipo con is
  Object datoConsulta = 'Hipertension leve';
  if (datoConsulta is String) {
    print(datoConsulta.length);  // smart cast — ya es String
  }

  // Cast explícito con as
  Object obj  = 'Cardiologia';
  String esp  = obj as String;

  // Comprobar nulabilidad
  String? diagnostico = null;
  int longitud = diagnostico?.length ?? 0;
  print(longitud);  // 0

  // Números especiales
  print(double.infinity);     // Infinity
  print(double.nan);          // NaN
  print(double.maxFinite);    // 1.7976931348623157e+308
}
