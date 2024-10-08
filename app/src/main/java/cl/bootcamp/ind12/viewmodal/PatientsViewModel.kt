package cl.bootcamp.ind12.viewmodal

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.ind12.modal.StatePATIENT

class PatientsViewModel : ViewModel(){
    private val _patients = mutableStateListOf<StatePATIENT>()
    val patients: List<StatePATIENT> get() = _patients

    fun addPatient(name: String) {
        val newId = _patients.size + 1 // Genera un ID único
        _patients.add(StatePATIENT(id = newId, name = name))
    }
}