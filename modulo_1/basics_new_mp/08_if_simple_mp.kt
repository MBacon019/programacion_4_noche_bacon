fun main() {
    println("Control de Flujo")
    println("If Simple")
    println("Temperatura corporal del paciente grados centig.")

    val temperatura = readLine()?.toDoubleOrNull() ?: 36.5

    if (temperatura >= 38.0) {
        println("Fiebre detectada")
    }

    if (temperatura >= 40.0) {
        println("Fiebre alta - Requiere atencion inmediata")
    }

    println("Temperatura registrada: $temperatura °C")
}
