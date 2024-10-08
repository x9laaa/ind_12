package cl.bootcamp.ind12.modal

class StateIMC (
    val peso: String = "",
    val alto: String = "",
    val edad: String = "",
    val imcResult: Float = 0f
){
    fun copy(
        peso: String = this.peso,
        alto: String = this.alto,
        edad: String = this.edad,
        imcResult: Float = this.imcResult
    ):StateIMC{
        return StateIMC(peso, alto, edad, imcResult)
    }

}