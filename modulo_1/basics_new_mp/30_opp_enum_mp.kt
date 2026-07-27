enum class EstadoConsulta(val descripcion: String, val esTerminal: Boolean) {
    AGENDADA    ("Cita programada",            false),
    EN_CURSO    ("Consulta en progreso",       false),
    COMPLETADA  ("Consulta finalizada",        true),
    CANCELADA   ("Cancelada por paciente",     true),
    NO_ASISTIO  ("Paciente no se presento",   true);

    fun puedeTransicionarA(siguiente: EstadoConsulta): Boolean = when (this) {
        AGENDADA  -> siguiente == EN_CURSO || siguiente == CANCELADA || siguiente == NO_ASISTIO
        EN_CURSO  -> siguiente == COMPLETADA || siguiente == CANCELADA
        else      -> false
    }
}

fun main() {
    val estado = EstadoConsulta.EN_CURSO
    println(estado.descripcion)  // Consulta en progreso
    println(estado.esTerminal)   // false

    val icono = when (estado) {
        EstadoConsulta.AGENDADA   -> "📅"
        EstadoConsulta.EN_CURSO   -> "🏥"
        EstadoConsulta.COMPLETADA -> "✅"
        EstadoConsulta.CANCELADA  -> "❌"
        EstadoConsulta.NO_ASISTIO -> "🚫"
    }
    println(icono)  // 🏥

    println(estado.puedeTransicionarA(EstadoConsulta.COMPLETADA))  // true
}
