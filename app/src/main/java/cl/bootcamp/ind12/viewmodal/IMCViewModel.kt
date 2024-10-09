package cl.bootcamp.ind12.viewmodal

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.ind12.modal.Imc


class IMCViewModel : ViewModel() {
    var state = mutableStateOf(Imc())
        private set

    fun updatePeso(peso: String) {
        state.value = state.value.copy(peso = peso)
    }

    fun updateAlto(alto: String) {
        state.value = state.value.copy(alto = alto)
    }

    fun updateEdad(edad: String) {
        state.value = state.value.copy(edad = edad)
    }



    fun validateFields(): Boolean {
        val pesoValue = state.value.peso.toFloatOrNull()
        val altoValue = state.value.alto.toFloatOrNull()
        val edadValue = state.value.edad.toIntOrNull()

        return pesoValue != null && pesoValue > 0 &&
                altoValue != null && altoValue > 0 &&
                edadValue != null && edadValue > 0
    }
    fun imcEstado(imc: String): String {
        val imcValue = imc.toFloatOrNull() ?: return "Valor no válido"
        return when {
            imcValue < 18.5 -> "Bajo peso"
            imcValue in 18.5..24.9 -> "Peso normal"
            imcValue in 25.0..29.9 -> "Pre-obesidad o Sobrepeso"
            imcValue in 30.0..34.9 -> "Obesidad clase I"
            imcValue in 35.0..39.9 -> "Obesidad clase II"
            imcValue >= 40 -> "Obesidad clase III"
            else -> "Valor no válido"
        }
    }
    fun calculateIMC() {
        val pesoValue = state.value.peso.toFloatOrNull() ?: 0f
        val altoValue = state.value.alto.toFloatOrNull()?.div(100) ?: 0f
        val imcResult = if (altoValue > 0) {
            val imc = pesoValue / (altoValue * altoValue)
            String.format("%.1f", imc)
        } else {
            "0.0"
        }
        state.value = state.value.copy(imcResult = imcResult)
        state.value = state.value.copy(imcEstado = imcEstado(imcResult))
    }

}