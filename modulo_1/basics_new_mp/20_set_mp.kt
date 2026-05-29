fun main() {
    println("Set")
    println("Inmutables")

    val codigosDiagnostico = setOf(101, 202, 303, 404, 606, 505, 303, 404, 202, 101, 101, 303)
    println(codigosDiagnostico)

    println("Operaciones de Conjuntos")
    val especialidadesManana = setOf("Cardiologia", "Neurologia", "Pediatria", "Cirugia", "Traumatologia")
    println("especialidades manana $especialidadesManana")

    val especialidadesTarde = setOf("Dermatologia", "Ginecologia", "Oncologia", "Psiquiatria")
    val especialidadesUrgentes = setOf("Cardiologia", "Neurologia", "Oncologia", "Cirugia")
    println("especialidades tarde $especialidadesTarde")

    println("union ${especialidadesManana union especialidadesTarde}")
    println("interseccion ${especialidadesManana intersect especialidadesTarde}")
    println("interseccion ${especialidadesUrgentes intersect especialidadesManana}")

    println("substraccion ${especialidadesManana subtract especialidadesTarde}")
    println("substraccion ${especialidadesManana subtract especialidadesUrgentes}")

    println("especialidades manana $especialidadesManana")
    println("especialidades tarde $especialidadesTarde")

    println("Set")
    println("Mutables")
    val medicosRegistrados = mutableSetOf("Dr. Lopez", "Dra. Garcia", "Dr. Martinez")
    println(medicosRegistrados)

    medicosRegistrados.add("Dr. Lopez")
    println(medicosRegistrados)

    medicosRegistrados.add("Dra. Torres")
    println(medicosRegistrados)

    medicosRegistrados.remove("Dr. Martinez")
    println(medicosRegistrados)

    println("Verificar si un medico existe ${"Dr. Lopez" in medicosRegistrados}")
    println("Verificar si un medico existe ${"Dr. Martinez" in medicosRegistrados}")
}
