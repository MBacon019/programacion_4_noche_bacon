data class Especialidad(val id: Int, val nombre: String)

data class ServicioMedico(
    val id:           Int,
    val nombre:       String,
    val costo:        Double,
    val cuposDisp:    Int,
    val especialidad: Especialidad,
    val activo:       Boolean = true
) {
    val disponible: Boolean    get() = activo && cuposDisp > 0
    val costoConIva: Double    get() = costo * 1.19

    fun aplicarDescuento(porcentaje: Double): ServicioMedico {
        require(porcentaje in 0.0..100.0) { "Descuento debe ser entre 0 y 100" }
        return copy(costo = costo * (1 - porcentaje / 100))
    }
}

object AgendaMedica {
    private val especialidades = mutableListOf(
        Especialidad(1, "Medicina General"),
        Especialidad(2, "Cardiologia"),
        Especialidad(3, "Pediatria")
    )
    private val servicios     = mutableListOf<ServicioMedico>()
    private var siguienteId   = 1

    fun agregarServicio(nombre: String, costo: Double, cupos: Int, especialidadId: Int): ServicioMedico? {
        val esp = especialidades.find { it.id == especialidadId } ?: return null
        val servicio = ServicioMedico(siguienteId++, nombre, costo, cupos, esp)
        servicios.add(servicio)
        return servicio
    }

    fun listar(): List<ServicioMedico>              = servicios.toList()
    fun disponibles(): List<ServicioMedico>         = servicios.filter { it.disponible }
    fun porEspecialidad(id: Int): List<ServicioMedico> = servicios.filter { it.especialidad.id == id }
    fun buscar(query: String): List<ServicioMedico> =
        servicios.filter { it.nombre.contains(query, ignoreCase = true) }
}

fun main() {
    AgendaMedica.agregarServicio("Consulta General",      50.0, 10, 1)
    AgendaMedica.agregarServicio("Electrocardiograma",   120.0,  0, 2)
    AgendaMedica.agregarServicio("Consulta Cardiologica", 90.0,  5, 2)
    AgendaMedica.agregarServicio("Control Pediatrico",    60.0,  8, 3)

    println("=== Todos los servicios ===")
    AgendaMedica.listar().forEach { s ->
        val estado = if (s.disponible) "✅" else "❌"
        println("$estado ${s.nombre} — ${"%.2f".format(s.costoConIva)} (con IVA)")
    }

    println("\n=== Disponibles con 10% descuento ===")
    AgendaMedica.disponibles()
        .map { it.aplicarDescuento(10.0) }
        .forEach { println("  ${it.nombre}: ${"%.2f".format(it.costo)}") }

    println("\n=== Lista de todos los servicios ==")
    for (servicio in AgendaMedica.listar()) {
        println("${servicio.nombre}")
    }
}
