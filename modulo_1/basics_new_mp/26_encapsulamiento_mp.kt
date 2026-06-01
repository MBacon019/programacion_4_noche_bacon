fun main() {
    println("Manipulacion de listas - Consultas Medicas")
    val diagnosticos = mutableListOf("Hipertension", "Diabetes", "Asma")
    println(diagnosticos)
    diagnosticos.add("Fiebre")
    println(diagnosticos)

    println("Buscar valores en una lista")
    println("Diabetes" in diagnosticos)
    println(diagnosticos.indexOf("Asma"))

    println("Ordenar una lista")
    val presiones = mutableListOf(140, 120, 160, 110, 150, 130)
    println(presiones)
    presiones.sort()
    println(presiones)
    presiones.sortDescending()
    println(presiones)
    val presionesOrdenadas = presiones.sorted()
    println(presionesOrdenadas)
    println(presiones)

    println("Map de pacientes")
    println("Crear un mapa")
    val expediente = mutableMapOf(
        "nombre" to "Carlos Ruiz",
        "edad" to 45,
        "especialidad" to "Cardiologia"
    )
    println(expediente["nombre"])
    expediente["nombre"] = "Carlos Alberto Ruiz"
    println(expediente["nombre"])
    expediente.remove("edad")
    println(expediente)
    println("nombre" in expediente)
    println("especialidad" in expediente)
    println(expediente.keys)
    println(expediente.values)
    println(expediente.entries)
    for ((clave, valor) in expediente) {
        println("$clave: $valor")
    }
}
