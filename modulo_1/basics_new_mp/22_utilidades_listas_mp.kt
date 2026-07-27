fun main() {
    println("Utilidades de Listas")
    val temperaturasPacientes = listOf(36.5, 37.0, 38.2, 39.1, 37.8, 40.0, 36.8, 38.5, 37.2, 39.5)
    println(temperaturasPacientes)

    // MAP: Transforma cada temperatura a clasificacion
    val clasificaciones = temperaturasPacientes.map { if (it >= 38.0) "Fiebre" else "Normal" }
    println(clasificaciones)

    val temperaturasTexto = temperaturasPacientes.map { "Temp: $it °C" }
    println(temperaturasTexto)

    println("Filter")

    val conFiebre = temperaturasPacientes.filter { it >= 38.0 }
    println(conFiebre)

    val mayores38 = temperaturasPacientes.filter { it > 38.0 }
    println(mayores38)

    val fiebreAlta = temperaturasPacientes.filter { it >= 39.0 && it > 38.0 }
    println(fiebreAlta)
    val sinFiebre = temperaturasPacientes.filterNot { it >= 38.0 }
    println(sinFiebre)
}
