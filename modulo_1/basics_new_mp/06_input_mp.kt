fun main() {
    println("Inputs")
    println("Escribe el nombre del paciente")
    val nombrePaciente = readLine()
    println("Hola $nombrePaciente")

    println("Escriba su temperatura corporal (°C): ")
    val temperatura = readLine()?.toDoubleOrNull() ?: 36.5
    println("Su temperatura es: $temperatura °C")

    val doble = temperatura * 2
    println("El doble de la temperatura es: ${doble}")
    println("El doble de la temperatura es: ${temperatura * 2}")
}
