fun main() {
    println("Map")
    println("Inmutables")
    
    // Creación de un mapa inmutable (Clave to Valor)
    val capitales = mapOf(
        "España" to "Madrid",
        "Francia" to "Paris",
        "Alemania" to "Berlin",
        "Italia" to "Roma"
    )
    
    // Acceso a valores
    println(capitales["España"]) // Imprime Madrid
    println(capitales["Portugal"]) // Imprime null (porque no existe)
    
    // Uso de getOrDefault para evitar nulos
    println(capitales.getOrDefault("España", "Desconocido"))
    println(capitales.getOrDefault("Portugal", "Desconocido"))
    
    // Propiedades del mapa
    println(capitales.keys)    // Solo las llaves (países)
    println(capitales.values)  // Solo los valores (ciudades)
    println(capitales.entries) // Todos los pares
    
    println(capitales)
    
    // Recorrer el mapa con un bucle for (desestructuración)
    for ((pais, capital) in capitales) {
        println("pais: $pais - capital: $capital")
    }
    
    // Recorrer solo las entradas
    for (capital in capitales) {
        println("capital: $capital")
    }
    
   println("Mutables")
    val inventario = mutableMapOf(
        "Laptops" to 10,
        "Impresoras" to 4,
        "Teclados" to 12,
        "Mouse" to 8
    )
    
    // Añadir un nuevo elemento
    inventario["Monitores"] = 5
    println(inventario)
    
    // Actualizar un valor existente
    inventario["Laptops"] = 20
    println(inventario)
    
    // Eliminar un elemento por su clave
    inventario.remove("Mouse")
    println(inventario)
    
    // Uso de getOrPut: 
    // Si la clave no existe, la añade con el valor dado. 
    // Si ya existe, no hace nada y devuelve el valor actual.
    inventario.getOrPut("Proyector") { 15 }
    println(inventario)
    
    inventario.getOrPut("Teclados") { 15 }
    println(inventario)
    
}