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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

            // Nombre ocupa todo el ancho
            Text(
                text = "Nombre : ${patient.name}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    if (patient.edad != null) {
                        Text(text = "Edad : ${patient.edad}",fontSize = 22.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (patient.imc.isNotEmpty()) {
                        Text(text = "IMC : ${patient.imc}",fontSize = 22.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {

                    if (patient.genero == 0) {
                        Text(text = "Hombre",fontSize = 22.sp,
                            fontWeight = FontWeight.Bold)
                    } else if (patient.genero == 1) {
                        Text(text = "Mujer",fontSize = 22.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (patient.imcEstado.isNotEmpty()) {
                        Text(text = patient.imcEstado,fontSize = 22.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botón de Calcular IMC alineado a la derecha
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick = { navController.navigate("imc/${patient.id}") }) {
                    Text("Calcular IMC")
                }
            }
        }
    }
}