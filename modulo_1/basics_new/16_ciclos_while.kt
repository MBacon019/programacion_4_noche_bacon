fun main() {
    println("CICLOS while")
    var contador = 1
    
    // Ciclo While
    while (contador <= 5) {
        println(contador)
        contador++
    }
    
    // Reinicio de variable
    contador = 1
    
    // Ciclo Do-While
    do {
        println(contador)
        contador++
    } while (contador <= 5)
    

    println("do while")
    contador = 1
    do {
        println(contador)
        contador++
    } while (contador <= 5)

    println("break - continue")
    contador = 1
    while (contador <= 10) {
        contador++
        if (contador == 3) continue
        if (contador == 7) break
        println(contador)
    }
}