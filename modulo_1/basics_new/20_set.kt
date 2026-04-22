fun main() {
    println("Set")
    println("Inmutables")
    
    // Al imprimir esto, verás que los números repetidos desaparecen
    val numeros = setOf(1, 2, 3, 4, 6, 5, 3, 4, 2, 1, 1, 3)
    println(numeros)
    
    println("Operaciones de Conjuntos")
    val pares = setOf(2, 4, 6, 8, 10)
    println("pares $pares")
    
    val impares = setOf(1, 3, 5, 7, 9)
    val multiplos3 = setOf(3, 6, 9, 12)
    println("impares $impares")
    
    // Operaciones matemáticas de conjuntos
    println("union ${impares union pares}")
    println("interseccion ${impares intersect pares}")
    println("interseccion ${multiplos3 intersect pares}")
    
    // Resta de conjuntos
    println("substraccion ${impares subtract pares}")
    println("substraccion ${impares subtract multiplos3}")
    
    println("pares $pares")
    println("impares $impares")  
    
    println("Set")
    println("Mutables")
    val lenguajes = mutableSetOf("kotlin", "java", "reactnative")
    println(lenguajes)
    
    // Intento de añadir un duplicado (no pasará nada)
    lenguajes.add("kotlin")
    println(lenguajes)
    
    // Añadir un elemento nuevo
    lenguajes.add("javascript")
    println(lenguajes)
    
    // Eliminar un elemento
    lenguajes.remove("java")
    println(lenguajes)
    
    // Verificación de existencia (devuelve true o false)
    println("Verificar si un valor existe ${"kotlin" in lenguajes}")
    println("Verificar si un valor existe ${"java" in lenguajes}")
    
    
 }