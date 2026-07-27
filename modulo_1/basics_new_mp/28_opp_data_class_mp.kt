data class Paciente(
    val id:           Int,
    val nombre:       String,
    val edad:         Int,
    val diagnostico:  String,
    val activo:       Boolean = true
)

fun main() {
    val p1 = Paciente(1, "Carlos Ruiz", 45, "Hipertension")
    val p2 = Paciente(1, "Carlos Ruiz", 45, "Hipertension")
    val p3 = Paciente(2, "Maria Lopez", 32, "Diabetes")

    // toString() automatico
    println(p1)

    // equals() por valor
    println(p1 == p2)   // true
    println(p1 == p3)   // false

    // copy() — nuevo objeto con cambios puntuales
    val pacienteInactivo = p1.copy(activo = false)
    val nuevoDiagnostico = p1.copy(diagnostico = "Hipertension controlada")

    // Desestructuracion
    val (id, nombre, edad) = p1
    println("$id: $nombre — $edad anos")

    // En bucles
    listOf(p1, p3).forEach { (idP, nombreP, edadP) ->
        println("[$idP] $nombreP: $edadP anos")
    }
}
