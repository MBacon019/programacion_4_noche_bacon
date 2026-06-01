fun main() {
    println("Conversiones")
    println("Entero a Numerico")
    val edadPaciente: Int = 45
    val pesoDecimal: Double = edadPaciente.toDouble()
    val codigoLong: Long = edadPaciente.toLong()
    val edadTexto: String = edadPaciente.toString()

    println("to Double $pesoDecimal")
    println("to Long $codigoLong")
    println("to String $edadTexto")

    println("String a Numerico")
    val numeroCita = "1024".toInt()
    val temperaturaDecimal = "37.5".toDouble()

    val invalido = "temperatura".toIntOrNull()
    println(invalido)
}
