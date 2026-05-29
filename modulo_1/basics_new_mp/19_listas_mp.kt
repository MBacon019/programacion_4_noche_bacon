fun main() {
    println("Listas")
    println("Inmutables")

    val medicamentos = listOf("Paracetamol", "Ibuprofeno", "Amoxicilina", "Omeprazol", "Metformina")

    println(medicamentos)
    println("Size: ${medicamentos.size}")

    println("Mostrar el elemento indice 0: ${medicamentos[0]}")
    println("Mostrar primer elemento: ${medicamentos.first()}")
    println("Mostrar ultimo elemento: ${medicamentos.last()}")

    println("Mostrar el elemento indice 2: ${medicamentos.get(2)}")
    println("Mostrar contenido segun indice: ${medicamentos.indexOf("Ibuprofeno")}")

    println("Verificar existencia de un elemento: ${medicamentos.contains("Omeprazol")}")
    println("Verificar existencia de un elemento: ${"Aspirina" in medicamentos}")

    println("Sublista: ${medicamentos.subList(1, 4)}")
    println("Tomar primeros 2 elementos: ${medicamentos.take(2)}")
    println("Suprimir tres primeros elementos: ${medicamentos.drop(3)}")
    println("Tomar los ultimos dos elementos: ${medicamentos.takeLast(2)}")

    println(medicamentos)
    println("Mutables")
    val pacientesEnEspera = mutableListOf("Carlos Ruiz", "Maria Lopez", "Juan Perez", "Ana Torres")
    println(pacientesEnEspera)

    pacientesEnEspera.add("Pedro Gomez")
    println(pacientesEnEspera)

    pacientesEnEspera.add(1, "Sofia Medina")
    println(pacientesEnEspera)

    pacientesEnEspera.remove("Pedro Gomez")
    println(pacientesEnEspera)

    pacientesEnEspera[1] = "Luis Vargas"
    println(pacientesEnEspera)

    println("Array deque")
    val turnosCitas = ArrayDeque<Int>()
    println(turnosCitas)

    turnosCitas.addFirst(1)
    println(turnosCitas)

    turnosCitas.addFirst(3)
    println(turnosCitas)

    turnosCitas.addLast(2)
    println(turnosCitas)

    turnosCitas.removeFirst()
    println(turnosCitas)

    turnosCitas.removeLast()
    println(turnosCitas)
}
