fun main() {
    println("When Condicionales")
    println("Ingrese el indice de masa corporal (IMC) del paciente:")

    val imc = readLine()?.toDoubleOrNull() ?: 0.0

    val clasificacion = when {
        imc < 18.5 -> "Bajo peso"
        imc < 25.0 -> "Peso normal"
        imc < 30.0 -> "Sobrepeso"
        imc < 35.0 -> "Obesidad grado I"
        imc < 40.0 -> "Obesidad grado II"
        else       -> "Obesidad grado III - Obesidad morbida"
    }

    println("IMC: $imc -> $clasificacion")
}
