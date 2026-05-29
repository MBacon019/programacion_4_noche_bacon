fun main() {
    println("Operadores Logicos")
    val tieneFiebre = true
    val tieneSeguroMedico = false
    val estaHospitalizado = true
    val esMenorEdad = false

    println("Operador And &&")
    println("tieneFiebre && tieneSeguroMedico ${tieneFiebre && tieneSeguroMedico}")
    println("tieneFiebre && estaHospitalizado ${tieneFiebre && estaHospitalizado}")

    println("Or Logico ||")
    println("tieneFiebre || tieneSeguroMedico ${tieneFiebre || tieneSeguroMedico}")
    println("tieneFiebre || estaHospitalizado ${tieneFiebre || estaHospitalizado}")
    println("esMenorEdad || tieneSeguroMedico ${esMenorEdad || tieneSeguroMedico}")

    println("esMenorEdad || tieneSeguroMedico || estaHospitalizado ${esMenorEdad || tieneSeguroMedico || estaHospitalizado}")
    println("Not Logico !")
    println("! tieneFiebre ${!tieneFiebre}")
    println("! esMenorEdad ${!esMenorEdad}")

    val texto = readLine()
    println(texto)
}
