// La interfaz define el contrato — QUE puede hacer
// Las implementaciones definen el COMO
interface Tratable {
    fun aplicarTratamiento(paciente: String): Boolean
    val nombreTratamiento: String
}

class ConsultaGeneral(val medico: String) : Tratable {
    override val nombreTratamiento = "Consulta General"
    override fun aplicarTratamiento(paciente: String): Boolean {
        println("Consulta con $medico para paciente: $paciente")
        return true
    }
}

class Cirugia(val tipo: String) : Tratable {
    override val nombreTratamiento = "Cirugia"
    override fun aplicarTratamiento(paciente: String): Boolean {
        println("Cirugia de $tipo para paciente: $paciente")
        return true
    }
}

class Rehabilitacion : Tratable {
    override val nombreTratamiento = "Rehabilitacion"
    override fun aplicarTratamiento(paciente: String): Boolean {
        println("Sesion de rehabilitacion para paciente: $paciente")
        return true
    }
}

class Telemedicina : Tratable {
    override val nombreTratamiento = "Telemedicina"
    override fun aplicarTratamiento(paciente: String): Boolean {
        println("Consulta virtual para paciente: $paciente")
        return true
    }
}

// Esta funcion no sabe ni le importa que tipo de tratamiento es
// Solo sabe que recibe algo que implementa Tratable — POLIMORFISMO
fun atenderPaciente(paciente: String, tratamiento: Tratable) {
    println("Iniciando ${tratamiento.nombreTratamiento}...")
    val exito = tratamiento.aplicarTratamiento(paciente)
    println(if (exito) "✅ Tratamiento completado" else "❌ Tratamiento fallido")
}

fun main() {
    val tratamientos: List<Tratable> = listOf(
        ConsultaGeneral("Dr. Rivera"),
        Cirugia("apendice"),
        Rehabilitacion(),
        Telemedicina()
    )

    // Misma funcion — comportamiento distinto segun el tipo
    tratamientos.forEach { atenderPaciente("Carlos Ruiz", it) }
}
