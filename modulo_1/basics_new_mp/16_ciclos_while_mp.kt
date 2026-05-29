fun main() {
    println("CICLOS while")
    var numeroCita = 1

    // Ciclo While
    while (numeroCita <= 5) {
        println("Cita numero: $numeroCita")
        numeroCita++
    }

    // Reinicio de variable
    numeroCita = 1

    // Ciclo Do-While
    do {
        println("Atendiendo cita: $numeroCita")
        numeroCita++
    } while (numeroCita <= 5)

    println("do while")
    numeroCita = 1
    do {
        println(numeroCita)
        numeroCita++
    } while (numeroCita <= 5)

    println("break - continue")
    numeroCita = 1
    while (numeroCita <= 10) {
        numeroCita++
        if (numeroCita == 3) continue
        if (numeroCita == 7) break
        println("Procesando cita: $numeroCita")
    }
}
