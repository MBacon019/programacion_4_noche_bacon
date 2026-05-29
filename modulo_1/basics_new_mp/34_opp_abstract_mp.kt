abstract class ProcedimientoMedico(val nombre: String) {
    // abstract — las subclases DEBEN implementar esto
    abstract val duracionMinutos: Int
    abstract val costoBase: Double
    abstract fun descripcion(): String

    // concreto — disponible en todas las subclases
    fun comparar(otro: ProcedimientoMedico): String = when {
        costoBase > otro.costoBase -> "$nombre es mas costoso que ${otro.nombre}"
        costoBase < otro.costoBase -> "$nombre es mas barato que ${otro.nombre}"
        else                       -> "$nombre y ${otro.nombre} tienen el mismo costo"
    }

    override fun toString() = "${descripcion()} | Costo: ${"%.2f".format(costoBase)}"
}

class ConsultaMedica(val especialidad: String) : ProcedimientoMedico("Consulta") {
    override val duracionMinutos: Int    get() = 30
    override val costoBase:       Double get() = 80.0
    override fun descripcion() = "Consulta de $especialidad"
}

class Examen(val tipoExamen: String) : ProcedimientoMedico("Examen") {
    override val duracionMinutos: Int    get() = 45
    override val costoBase:       Double get() = 150.0
    override fun descripcion() = "Examen de $tipoExamen"
}

class ProcedimientoQuirurgico(val tipoOperacion: String) : ProcedimientoMedico("Cirugia") {
    override val duracionMinutos: Int    get() = 180
    override val costoBase:       Double get() = 2500.0
    override fun descripcion() = "Cirugia de $tipoOperacion"
}

fun main() {
    // POLIMORFISMO: la lista acepta cualquier ProcedimientoMedico
    val procedimientos: List<ProcedimientoMedico> = listOf(
        ConsultaMedica("Cardiologia"),
        Examen("sangre"),
        ProcedimientoQuirurgico("apendice")
    )

    procedimientos.forEach { println(it) }  // toString polimorfico

    val masC = procedimientos.maxByOrNull { it.costoBase }
    println("\nProcedimiento mas costoso: ${masC?.nombre}")

    println(procedimientos[0].comparar(procedimientos[1]))
}
