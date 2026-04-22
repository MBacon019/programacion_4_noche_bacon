fun main() {
    println("Listas")
    println("Inmutables")
    
    // Creación de una lista inmutable
    val frutas = listOf("manzana", "banana", "cereza", "pera", "piña")
    
    println(frutas)
    println("Size: ${frutas.size}")
    
    // Acceso a elementos por índice y funciones
    println("Mostrar el elemento indice 0: ${frutas[0]}")
    println("Mostrar primer elemento: ${frutas.first()}")
    println("Mostrar último elemento: ${frutas.last()}")
    
    println("Mostrar el elemento indice 2: ${frutas.get(2)}")
    println("Mostrar contenido segun indice: ${frutas.indexOf("banana")}")
    
    // Verificación de existencia
    println("Verificar existencia de un elemento: ${frutas.contains("piña")}")
    println("Verificar existencia de un elemento: ${"naranja" in frutas}")
    
    // Sublistas y manipulación (generan nuevas listas)
    // Sublista
    println("Sublista: ${frutas.subList(1, 4)}")
    println("Tomar primeros 2 elementos: ${frutas.take(2)}")
    println("Suprimir tres primeros elementos: ${frutas.drop(3)}")
    println("Tomar los ultimos dos elementos: ${frutas.takeLast(2)}")
    
    println(frutas)
    println("Mutables")
    val colores = mutableListOf("blanco", "azul", "amarillo", "rojo")
    println(colores)
    
    // Agregar elementos
    colores.add("verde")
    println(colores)
    
    // Agregar en un índice específico (desplaza el resto)
    colores.add(1, "morado")
    println(colores)
    
    // Eliminar elementos
    colores.remove("verde")
    println(colores)
    
    // Modificar un elemento por su índice
    colores[1] = "gris"
    println(colores)

    println("Array deque")
    val numeros = ArrayDeque<Int>()
    println(numeros)
    
    // Agregar al principio
    numeros.addFirst(1)
    println(numeros)
    
    numeros.addFirst(3)
    println(numeros)
    
    // Agregar al final
    numeros.addLast(2)
    println(numeros)
    
    // Eliminar el primero
    numeros.removeFirst()
    println(numeros)
    
    // Eliminar el último
    numeros.removeLast()
    println(numeros)

}