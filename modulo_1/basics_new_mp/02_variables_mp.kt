fun main() {
    val nombrePaciente = "Carlos"
    val edadPaciente: Int = 45
    var numeroCita = 0
    numeroCita = numeroCita + 1

    println("$nombrePaciente tiene $edadPaciente años")

    val idCita: Byte = 101
    val codigoSala: Short = 305
    val numeroPaciente: Int = 12
    val historiaClinica: Long = 2_024_000_001L

    println(idCita)
    println(codigoSala)
    println(numeroPaciente)
    println(historiaClinica)

    val activo: Boolean = true
    val grupoSanguineo: Char = 'O'
    val diagnostico: String = "Hipertension leve"

    val inferidoString = "Consulta General"
    println("Tipo: ${inferidoString::class.simpleName}")

    val inferidoInt = 38
    println("Tipo: ${inferidoInt::class.simpleName}")

    val primerNombreMedico = "Laura"
    val apellidoMedico = "Gomez"

    val primerNombreMayuscula = primerNombreMedico.uppercase()
    val apellidoMayuscula = apellidoMedico.uppercase()

    println("Medico tratante: ${primerNombreMayuscula} ${apellidoMayuscula}")
    println("Medico tratante: ${primerNombreMedico.uppercase()} ${apellidoMedico.uppercase()}")
}
