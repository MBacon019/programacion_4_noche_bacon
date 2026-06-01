package com.example.compose_mp.model

data class Medico(
    val id:           Int,
    val nombre:       String,
    val especialidad: String,
    val consultorio:  String,
    val disponible:   Boolean = true
)

val medicosDeMuestra = listOf(
    Medico(1, "Dr. Carlos Méndez", "Cardiología",   "Consultorio 101"),
    Medico(2, "Dra. María Vega",   "Pediatría",     "Consultorio 102"),
    Medico(3, "Dr. Juan López",    "Dermatología",  "Consultorio 103", disponible = false),
    Medico(4, "Dra. Rosa Suárez",  "Ginecología",   "Consultorio 104"),
    Medico(5, "Dr. Andrés Mora",   "Traumatología", "Consultorio 105", disponible = false),
    Medico(6, "Dr. Luis Herrera",  "Neurología",    "Consultorio 106"),
    Medico(7, "Dra. Elena Ramos",  "Oftalmología",  "Consultorio 107"),
    Medico(8, "Dr. Pablo Castro",  "Odontología",   "Consultorio 108", disponible = false),
)
