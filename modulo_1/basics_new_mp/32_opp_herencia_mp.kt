// Sin open — no se puede heredar (proteccion por defecto)
class PersonalMedico(val nombre: String)
// class Medico : PersonalMedico("Dr. Lopez")  // ERROR — PersonalMedico es final

// Con open — la jerarquia esta disenada para ello
open class PersonalSalud(val nombre: String, val especialidad: String) {
    open fun atenderPaciente() = println("$nombre atiende en $especialidad")
    open fun descripcion() = "Soy $nombre"

    // Sin open — la subclase NO puede sobreescribir
    fun registrarTurno() = println("$nombre registra su turno")
}

// HERENCIA: Medico reutiliza todo de PersonalSalud y especializa atenderPaciente
class Medico(nombre: String, especialidad: String) : PersonalSalud(nombre, especialidad) {
    override fun atenderPaciente() {
        super.atenderPaciente()
        println("(realiza diagnostico y prescripcion)")
    }
    override fun descripcion() = "${super.descripcion()}, medico de $especialidad"
}

class Enfermera(nombre: String, val turno: String) : PersonalSalud(nombre, "Enfermeria") {
    override fun descripcion() =
        "${super.descripcion()}, enfermera de turno ${turno}"
}

fun main() {
    val medico = Medico("Dr. Rivera", "Cardiologia")
    medico.atenderPaciente()
    // Dr. Rivera atiende en Cardiologia
    // (realiza diagnostico y prescripcion)

    val enfermera = Enfermera("Lic. Gomez", "Noche")
    println(enfermera.descripcion())  // Soy Lic. Gomez, enfermera de turno Noche

    medico.registrarTurno()  // Dr. Rivera registra su turno — heredado de PersonalSalud
}
