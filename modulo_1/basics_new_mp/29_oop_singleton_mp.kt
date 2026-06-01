object SistemaConsultas {
    val hospital:   String = "Clinica San Rafael"
    val version:    Int    = 2
    private val apiKey: String = "sk-consultas-secreto-456"

    fun urlBase() = "https://$hospital.com/api/v$version"
    fun encabezados() = mapOf("Authorization" to "Bearer $apiKey")
}

class Medico private constructor(val id: Int, val nombre: String) {
    companion object {
        private var contadorId = 0

        fun registrar(nombre: String, matricula: String): Medico? {
            if (nombre.isBlank() || matricula.isBlank()) return null
            return Medico(++contadorId, nombre.trim())
        }

        const val ESPECIALIDAD_DEFAULT = "Medicina General"
    }
}

fun main() {
    println(SistemaConsultas.urlBase())  // https://Clinica San Rafael.com/api/v2
    // SistemaConsultas.apiKey           // ERROR — privado

    val medico = Medico.registrar("Dra. Laura Gomez", "MAT-1234")
    println(medico)
}
