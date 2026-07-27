// Clase base — comportamiento y datos comunes
class PersonalSalud {
  final String nombre;
  final int    anosExperiencia;

  PersonalSalud(this.nombre, this.anosExperiencia);

  // Método que cada subclase debe especializar
  String realizarTarea() => '...';

  // Método común — reutilizado sin cambios por todas las subclases
  void presentarse() {
    print('Soy $nombre, tengo $anosExperiencia años de experiencia y: ${realizarTarea()}');
  }
}

// HERENCIA: Medico y Enfermera reutilizan PersonalSalud y lo especializan
class Medico extends PersonalSalud {
  Medico(super.nombre, super.anosExperiencia);

  @override
  String realizarTarea() => 'diagnostico y prescripción';

  void atenderPaciente(String paciente) => print('$nombre atiende a $paciente 🩺');
}

class Enfermera extends PersonalSalud {
  Enfermera(super.nombre, super.anosExperiencia);

  @override
  String realizarTarea() => 'toma signos vitales';

  void administrarMedicamento(String paciente) =>
      print('$nombre administra medicamento a $paciente 💊');
}

void main() {
  final medico    = Medico('Dr. Rivera', 12);
  final enfermera = Enfermera('Lic. Gómez', 8);

  medico.presentarse();     // Soy Dr. Rivera, tengo 12 años de experiencia y: diagnostico y prescripción
  enfermera.presentarse();  // Soy Lic. Gómez, tengo 8 años de experiencia y: toma signos vitales

  medico.atenderPaciente('Carlos Ruiz');
  enfermera.administrarMedicamento('María López');
}
