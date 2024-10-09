package cl.bootcamp.ind12.modal

data class Patient(
    val id: Int,
    val name: String,
    val edad: Int?,
    val genero: Int?,
    val imc: String,
    val imcEstado: String
)