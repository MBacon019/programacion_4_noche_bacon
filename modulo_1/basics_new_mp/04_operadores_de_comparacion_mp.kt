// Operadores de comparacion
fun main() {
    var presionSistolica = 140
    var presionDiastolica = 90

    println("presionSistolica==presionDiastolica ${presionSistolica == presionDiastolica}")
    println("presionSistolica!=presionDiastolica ${presionSistolica != presionDiastolica}")
    println("presionSistolica>presionDiastolica ${presionSistolica > presionDiastolica}")
    println("presionSistolica<presionDiastolica ${presionSistolica < presionDiastolica}")
    println("presionSistolica>=presionDiastolica ${presionSistolica >= presionDiastolica}")
    println("presionSistolica<=presionDiastolica ${presionSistolica <= presionDiastolica}")

    var diagnostico1 = "hipertension"
    var diagnostico2 = "hipertension"

    println("diagnostico1===diagnostico2 ${diagnostico1 === diagnostico2}")
    println("diagnostico1==diagnostico2 ${diagnostico1 == diagnostico2}")
    println("diagnostico1.equals(diagnostico2) ${diagnostico1.equals(diagnostico2)}")
}
