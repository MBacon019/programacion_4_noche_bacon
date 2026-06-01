package com.example.compose_mp.model

data class Consulta(
    val id:           Int,
    val paciente:     String,
    val cedula:       String,
    val medico:       String,
    val especialidad: String,
    val fecha:        String,
    val hora:         String,
    val estado:       String  = "Pendiente",
    val urgente:      Boolean = false
)

val consultasDeMuestra = listOf(
    Consulta(1, "Ana Rodríguez",  "0912345678", "Dr. Carlos Méndez", "Cardiología",   "2025-06-01", "08:00", urgente = true),
    Consulta(2, "Luis Pérez",     "0923456789", "Dra. María Vega",   "Pediatría",     "2025-06-01", "09:00"),
    Consulta(3, "Sofía Torres",   "0934567890", "Dr. Juan López",    "Dermatología",  "2025-06-01", "10:00", estado = "Atendida"),
    Consulta(4, "Carlos Ruiz",    "0945678901", "Dra. Rosa Suárez",  "Ginecología",   "2025-06-01", "11:00"),
    Consulta(5, "María Molina",   "0956789012", "Dr. Carlos Méndez", "Cardiología",   "2025-06-02", "08:30", urgente = true),
    Consulta(6, "Pedro García",   "0967890123", "Dr. Andrés Mora",   "Traumatología", "2025-06-02", "09:30", estado = "Cancelada"),
    Consulta(7, "Elena Castro",   "0978901234", "Dra. María Vega",   "Pediatría",     "2025-06-02", "10:30"),
    Consulta(8, "Diego Mora",     "0989012345", "Dr. Luis Herrera",  "Neurología",    "2025-06-02", "11:30", estado = "Atendida"),
)
