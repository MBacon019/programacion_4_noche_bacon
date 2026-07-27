fun main() {
    println("When Basico")
    println("Ingrese el grupo sanguineo del paciente (A/B/AB/O):")

    val grupoSanguineo = readLine()?.trim()?.uppercase() ?: ""

    when (grupoSanguineo) {
        "A"  -> println("Grupo A - Puede donar a A y AB, recibe de A y O")
        "B"  -> println("Grupo B - Puede donar a B y AB, recibe de B y O")
        "AB" -> println("Grupo AB - Receptor universal, dona solo a AB")
        "O"  -> println("Grupo O - Donante universal, recibe solo de O")
        else -> println("Grupo sanguineo no reconocido")
    }
}
