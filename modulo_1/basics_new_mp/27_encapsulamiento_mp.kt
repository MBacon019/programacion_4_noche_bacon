class Consulta(val duracionMinutos: Double, val costoBase: Double) {
    val costoTotal:    Double get() = costoBase + (duracionMinutos * 0.5)
    val duracionHoras: Double get() = duracionMinutos / 60.0

    constructor(duracionMinutos: Int, costoBase: Int) : this(duracionMinutos.toDouble(), costoBase.toDouble())
    constructor(costoBase: Double) : this(30.0, costoBase)

    override fun toString() = "Consulta(${duracionMinutos}min) | costo=$${"%.2f".format(costoTotal)}"
}

fun main() {
    val c1 = Consulta(45.0, 80.0)
    val c2 = Consulta(80.0)       // duracion por defecto 30 min
    val c3 = Consulta(60, 100)    // con Int

    println(c1)  // Consulta(45.0min) | costo=$102.50
    println(c2)  // Consulta(30.0min) | costo=$95.00
}
