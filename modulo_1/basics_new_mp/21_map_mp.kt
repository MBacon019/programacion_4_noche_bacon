fun main() {
    println("Map")
    println("Inmutables")

    val medicosPorEspecialidad = mapOf(
        "Cardiologia" to "Dr. Rivera",
        "Pediatria"   to "Dra. Morales",
        "Neurologia"  to "Dr. Castro",
        "Ginecologia" to "Dra. Herrera"
    )

    println(medicosPorEspecialidad["Cardiologia"])
    println(medicosPorEspecialidad["Oncologia"])

    println(medicosPorEspecialidad.getOrDefault("Cardiologia", "Sin asignar"))
    println(medicosPorEspecialidad.getOrDefault("Oncologia", "Sin asignar"))

    println(medicosPorEspecialidad.keys)
    println(medicosPorEspecialidad.values)
    println(medicosPorEspecialidad.entries)

    println(medicosPorEspecialidad)

    for ((especialidad, medico) in medicosPorEspecialidad) {
        println("Especialidad: $especialidad - Medico: $medico")
    }

    for (entrada in medicosPorEspecialidad) {
        println("entrada: $entrada")
    }

    println("Mutables")
    val stockMedicamentos = mutableMapOf(
        "Paracetamol"  to 100,
        "Ibuprofeno"   to 50,
        "Amoxicilina"  to 30,
        "Omeprazol"    to 80
    )

    stockMedicamentos["Metformina"] = 60
    println(stockMedicamentos)

    stockMedicamentos["Paracetamol"] = 200
    println(stockMedicamentos)

    stockMedicamentos.remove("Omeprazol")
    println(stockMedicamentos)

    stockMedicamentos.getOrPut("Aspirina") { 45 }
    println(stockMedicamentos)

    stockMedicamentos.getOrPut("Ibuprofeno") { 45 }
    println(stockMedicamentos)
}
