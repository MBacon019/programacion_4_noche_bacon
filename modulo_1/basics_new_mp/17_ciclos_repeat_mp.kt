fun main() {
    println("CICLOS repeat")
    println("Cuantas mediciones de presion arterial tomar:")
    val mediciones = readLine()?.toIntOrNull() ?: 3
    var totalPresion = 0

    repeat(mediciones) { i ->
        println("Medicion ${i + 1} - Presion sistolica (mmHg):")
        val presion = readLine()?.toIntOrNull() ?: 0
        totalPresion += presion
    }

    val promedio = totalPresion / mediciones
    println("Presion arterial promedio: $promedio mmHg")
    println("Clasificacion: ${
        when {
            promedio < 90  -> "Hipotension"
            promedio <= 119 -> "Normal"
            promedio <= 139 -> "Pre-hipertension"
            promedio <= 179 -> "Hipertension etapa 1"
            else           -> "Hipertension etapa 2"
        }
    }")
}
