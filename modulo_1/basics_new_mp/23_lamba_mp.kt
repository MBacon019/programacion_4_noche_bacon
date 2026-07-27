fun main() {
    println("Lambdas - Consultas Medicas")

    val pacientes = listOf(
        Pair("Carlos Ruiz", 38.5),
        Pair("Maria Lopez", 36.8),
        Pair("Juan Perez", 39.2),
        Pair("Ana Torres", 37.0),
        Pair("Pedro Gomez", 40.1)
    )

    // Lambda como variable
    val tieneFiebre: (Double) -> Boolean = { temperatura -> temperatura >= 38.0 }

    // Filtrar pacientes con fiebre usando lambda
    val pacientesConFiebre = pacientes.filter { tieneFiebre(it.second) }
    println("Pacientes con fiebre:")
    pacientesConFiebre.forEach { println("  ${it.first}: ${it.second} °C") }

    // Lambda para clasificar temperatura
    val clasificarTemperatura = { temp: Double ->
        when {
            temp < 36.0 -> "Hipotermia"
            temp < 38.0 -> "Normal"
            temp < 39.0 -> "Fiebre leve"
            temp < 40.0 -> "Fiebre moderada"
            else        -> "Fiebre alta"
        }
    }

    println("\nClasificacion de todos los pacientes:")
    pacientes.forEach { (nombre, temp) ->
        println("  $nombre -> ${clasificarTemperatura(temp)}")
    }
}
