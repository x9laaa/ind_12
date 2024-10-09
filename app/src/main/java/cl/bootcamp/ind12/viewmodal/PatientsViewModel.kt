package cl.bootcamp.ind12.viewmodal

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.ind12.modal.Patient

class PatientsViewModel : ViewModel(){
    private val _patients = mutableStateListOf<Patient>()
    val patients: List<Patient> get() = _patients

    fun addPatient(name: String) {
        val newId = _patients.size + 1 // Genera un ID único
        _patients.add(Patient(id = newId, name = name, edad = null, genero =null, imc = ""))
    }

    fun updatePatient(patientId: String?, edad: Int?, imc: String) {
        val id = patientId!!.toInt()
        val patient = _patients[id-1]
        val updatedPatient = patient.copy(edad = edad, imc = imc)
        _patients[id-1] = updatedPatient // Actualizar el paciente en el mapa

    }
}