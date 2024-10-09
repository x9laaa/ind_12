package cl.bootcamp.ind12.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.ind12.modal.Patient


@Composable
fun PatientCard(patient: Patient, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(text = "Nombre : ${patient.name}")

            if (patient.genero == 0) { Text(text = "Genero : Hombre")
            } else if (patient.genero == 1) {Text(text = "Genero : Mujer")}

            if (patient.edad != null) Text(text = "Edad : ${patient.edad}")

            if (patient.imc != "")  Text(text = "IMC : ${patient.imc}")

            if (patient.imcEstado != "")  Text(text = patient.imcEstado)

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
            ) {
                Button(onClick = { navController.navigate("imc/${patient.id}") }){
                    Text("Calcular IMC")
                }
            }
        }
    }
}