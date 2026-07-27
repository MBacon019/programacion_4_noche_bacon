fun main() {
    val nombre = "Marcelo"
    val edad: Int = 26
    var contador = 0 
    contador = contador + 1
    
    println("$nombre tiene $edad años")

    val n1: Byte = 127
    val n2: Short = 32_767
    val n3: Int = 12
    val n4: Long = 2_222_222_222_2L 

    println(n1)
    println(n2)
    println(n3)
    println(n4)

    val boleano: Boolean = true
    val caracter: Char = 'k'
    val cadena: String = " Kotlin"

    val inferidoString = "String"
    println("Tipo: ${inferidoString::class.simpleName}")
    
    val inferidoInt = 12
    println("Tipo: ${inferidoInt::class.simpleName}")

    val primerNombre = "Alex"
    val primerApellido = "Perez" // Corregido: "primerapellido" -> "primerApellido"
    
    val primerNombreMayuscula = primerNombre.uppercase()
    val primerApellidoMayuscula = primerApellido.uppercase()

    println("Nombre completo: ${primerNombreMayuscula}${primerApellidoMayuscula}")
    println("Nombre completo: ${primerNombre.uppercase()}${primerApellido.uppercase()}")
}
