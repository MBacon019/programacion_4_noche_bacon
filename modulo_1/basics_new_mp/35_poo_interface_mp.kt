interface Diagnosticable { fun diagnosticar() = println("Realizando diagnostico general") }
interface Prescribible   { fun prescribir()  = println("Emitiendo prescripcion medica") }

class MedicoGeneral : Diagnosticable, Prescribible {
    // Obligatorio cuando ambas tienen implementacion del mismo metodo con conflicto
    override fun diagnosticar() {
        super<Diagnosticable>.diagnosticar()
        println("Diagnostico completo emitido por medico general")
    }
    override fun prescribir() {
        super<Prescribible>.prescribir()
        println("Receta firmada por medico general")
    }
}
