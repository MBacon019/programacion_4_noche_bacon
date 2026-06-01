fun main() {
    registrarConsulta()
    saludarPaciente("Ana Torres")
    val costo1 = 50.0
    val costo2 = 30.0
    println("Total consulta + medicamento: ${calcularTotal(costo1, costo2)}")
    println("Descuento: ${aplicarDescuento(costo1, costo2)}")
    calcularIMC()
    println("Costo con IVA: ${agregarImpuesto(costo1, costo2)}")
}

fun registrarConsulta() {
    println("Consulta medica registrada en el sistema")
}

fun saludarPaciente(nombre: String) {
    println("Buenos dias, paciente: $nombre")
}

fun calcularTotal(costoConsulta: Double, costoMedicamento: Double): Double {
    return costoConsulta + costoMedicamento
}

// funcion simplificada
fun aplicarDescuento(costoBase: Double, descuento: Double) = costoBase - descuento

// funcion dentro de funcion
fun calcularIMC() {
    fun imc(peso: Double, talla: Double) = peso / (talla * talla)
    println("IMC ejemplo: ${"%.2f".format(imc(70.0, 1.70))}")
}

// funciones como variables
val agregarImpuesto = { base: Double, iva: Double -> base + (base * iva / 100) }
