fun main() {
    println("Control de Flujo")
    println("If Multiples Condicionales")
    println("Ingrese la presion sistolica del paciente (mmHg):")

    val presion = readLine()?.toIntOrNull() ?: 120

    if (presion < 90) {
        println("Presion baja - Hipotension")
    } else if (presion in 90..119) {
        println("Presion normal")
    } else if (presion in 120..139) {
        println("Presion elevada - Pre-hipertension")
    } else if (presion in 140..179) {
        println("Hipertension etapa 1")
    } else {
        println("Hipertension etapa 2 - Urgencia medica")
    }

    println("Presion registrada: $presion mmHg")
}
