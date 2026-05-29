fun main() {
    println("when con bloques de codigo")
    println("Nombre Paciente:")
    val paciente = readLine()?.trim() ?: ""

    println("Nivel de alerta CRITICO/URGENTE/MODERADO/LEVE:")
    val nivel = readLine()?.trim()?.uppercase() ?: ""

    when (nivel) {
        "CRITICO" -> {
            println("ALERTA CRITICA - Paciente: $paciente")
            println("Accion inmediata")
            println("Registrar hora de activacion de protocolo")
        }
        "URGENTE" -> {
            println("URGENTE - Paciente: $paciente")
            println("Priorizar en Sala de Espera")
            println("Reevaluar en 15 minutos")
        }
        "MODERADO" -> println("Moderado - Paciente: $paciente, registrar y monitorear")
        "LEVE"     -> println("Leve - Paciente: $paciente, registrar en lista normal")
        else       -> println("Nivel de alerta no reconocido")
    }

    println("Edad:")
    val edad = readLine()?.toIntOrNull() ?: 0
    val clasificacionEdad = when (edad) {
        in 0..2   -> "Neonatal"
        in 3..11  -> "Pediatrico"
        in 12..17 -> "Adolescente"
        in 18..64 -> "Adulto"
        else      -> "Adulto Mayor"
    }

    println("$edad años -> $clasificacionEdad")
}
