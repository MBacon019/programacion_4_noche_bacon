fun main() {
    registrarConsulta()
    println("Funcion con parametros")
    saludarPaciente("Carlos")
    saludarPaciente("Maria")

    println("Funcion con retorno")
    println(calcularTotal(80.0, 30.0))

    println("Funcion por posicion y por nombre")
    registrarPaciente("Carlos", 45, "Cardiologia")
    registrarPaciente("Maria", 30, "Pediatria")
    registrarPaciente(edad = 45, nombre = "Carlos", especialidad = "Neurologia")

    println("Funcion con valor por defecto")
    agendarCita("Carlos", "Consulta general", "08:00")
    agendarCita("Maria", hora = "10:30")
    agendarCita("Juan", "Urgencia")

    println("Funcion con parametros posicionales")
    println(sumarCostos(80.0, 30.0, 15.0))
    println(sumarCostos(50.0, 20.0, 10.0, 5.0))

    println("Funcion con parametros combinados")
    mostrarHistorial("Historial Clinico", "Hipertension", "Diabetes", "Asma")

    println("Funcion parametros clave valor variables")
    crearExpediente(nombre = "Carlos Ruiz", edad = 45, diagnostico = "Hipertension", seguro = "IMSS")

    println("Funcion con multiples valores")
    val presiones = listOf(120, 130, 140, 125, 135)
    val (minPresion, maxPresion) = analizarPresiones(presiones)
    println("Min: $minPresion, Max: $maxPresion")
}

fun registrarConsulta() {
    println("Consulta medica registrada")
}

fun saludarPaciente(nombre: String) {
    println("Bienvenido al consultorio, $nombre")
}

fun calcularTotal(costoConsulta: Double, costoMedicamento: Double): Double {
    return costoConsulta + costoMedicamento
}

fun registrarPaciente(nombre: String, edad: Int, especialidad: String) {
    println("Paciente $nombre, $edad anos, asignado a $especialidad")
}

fun agendarCita(nombre: String, tipo: String = "Consulta general", hora: String = "09:00") {
    println("Cita agendada: $nombre - $tipo a las $hora")
}

fun sumarCostos(vararg costos: Double): Double {
    return costos.sum()
}

fun mostrarHistorial(titulo: String, vararg diagnosticos: String) {
    println("$titulo:")
    for (dx in diagnosticos) {
        println(" - $dx")
    }
}

fun crearExpediente(nombre: String = "", edad: Int = 0, diagnostico: String = "", seguro: String = "") {
    println("Expediente: nombre=$nombre, edad=$edad, diagnostico=$diagnostico, seguro=$seguro")
}

fun analizarPresiones(presiones: List<Int>): Pair<Int, Int> {
    return Pair(presiones.minOrNull() ?: 0, presiones.maxOrNull() ?: 0)
}
