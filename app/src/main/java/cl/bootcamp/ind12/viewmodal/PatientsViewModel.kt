package cl.bootcamp.ind12.viewmodal

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.ind12.modal.Patient

class PatientsViewModel : ViewModel(){
    private val _patients = mutableStateListOf<Patient>()
    val patients: List<Patient> get() = _patients

    fun addPatient(name: String) {
        val newId = _patients.size + 1 // Genera un ID único
        _patients.add(Patient(id = newId, name = name))
    }
}