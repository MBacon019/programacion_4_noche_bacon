fun main() {
    println("Control de Flujo")
    println("If Condicionales Anidadas")
    println("Edad del paciente:")

    val edad = readLine()?.toIntOrNull() ?: 0

    println("¿Tiene sintomas graves? s/n")
    val sintomasGraves = readLine()?.trim()?.lowercase() == "s"

    if (edad < 18) {
        if (sintomasGraves) {
            println("Menor con sintomas graves - Derivar a pediatria urgente")
        } else {
            println("Menor sin urgencia - Consulta pediatrica programada")
        }
    } else if (edad >= 60) {
        if (sintomasGraves) {
            println("Adulto mayor con sintomas graves - Prioridad alta")
        } else {
            println("Adulto mayor - Consulta geriatrica programada")
        }
    } else {
        if (sintomasGraves) {
            println("Adulto con sintomas graves - Consulta urgente")
        } else {
            println("Adulto sin urgencia - Consulta general programada")
        }
    }
}
