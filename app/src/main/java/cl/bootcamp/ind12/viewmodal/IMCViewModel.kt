package cl.bootcamp.ind12.viewmodal

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.ind12.modal.StateIMC


class IMCViewModel : ViewModel() {
    var state = mutableStateOf(StateIMC())
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

    fun calculateIMC() {
        val pesoValue = state.value.peso.toFloatOrNull() ?: 0f
        val altoValue = state.value.alto.toFloatOrNull()?.div(100) ?: 0f // Convertir cm a metros
        val imcResult = if (altoValue > 0) pesoValue / (altoValue * altoValue) else 0f
        state.value = state.value.copy(imcResult = imcResult)
    }
}