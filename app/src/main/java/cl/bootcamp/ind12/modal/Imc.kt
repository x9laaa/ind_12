package cl.bootcamp.ind12.modal

class Imc (
    val peso: String = "",
    val alto: String = "",
    val edad: String = "",
    val imcResult: String = "",
    val imcEstado: String = ""
){
    fun copy(
        peso: String = this.peso,
        alto: String = this.alto,
        edad: String = this.edad,
        imcResult: String = this.imcResult,
        imcEstado: String = this.imcEstado
    ):Imc{
        return Imc(peso, alto, edad, imcResult, imcEstado)
    }

}