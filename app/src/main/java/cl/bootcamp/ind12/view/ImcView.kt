package cl.bootcamp.ind12.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import cl.bootcamp.ind12.components.CustomButton
import cl.bootcamp.ind12.components.CustomOutlinedTextField
import cl.bootcamp.ind12.components.CustomSpacer
import cl.bootcamp.ind12.components.CustomText
import cl.bootcamp.ind12.components.SegmentedButtonSingleSelect
import cl.bootcamp.ind12.viewmodal.IMCViewModel
import cl.bootcamp.ind12.viewmodal.PatientsViewModel

@Composable
fun ImcView(
    navController: NavController,
    patientId: String?,
    viewModel: PatientsViewModel = viewModel()
) {
    val viewModelD: IMCViewModel = viewModel()
    var selectedIndex by remember { mutableIntStateOf(-1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var showDialog by remember { mutableStateOf(false) }
        var dialogMessage by remember { mutableStateOf("") }

        if (showDialog) {
            AlertDialog(onDismissRequest = { showDialog = false },
                title = { Text("¡CUIDADO!") },
                text = { Text(dialogMessage) },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Entendido")
                    }
                })
        }

        CustomText("Calculadora de IMC")

        SegmentedButtonSingleSelect(
            selectedIndex = selectedIndex,
            onSelectedIndexChange = { selectedIndex = it })
        CustomSpacer()

        CustomOutlinedTextField(label = "Edad (Años)",
            value = viewModelD.state.value.edad,
            onValueChange = { viewModelD.updateEdad(it) })
        CustomSpacer()
        CustomOutlinedTextField(label = "Peso (Kg)",
            value = viewModelD.state.value.peso,
            onValueChange = { viewModelD.updatePeso(it) })
        CustomSpacer()
        CustomOutlinedTextField(label = "Altura (Cm)",
            value = viewModelD.state.value.alto,
            onValueChange = { viewModelD.updateAlto(it) })
        CustomSpacer()

        CustomButton(
            text = "Calcular", modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp
                )
        ) {

            if (viewModelD.validateFields()) {
                viewModelD.calculateIMC()


            } else {
                dialogMessage = "No te olvides de llenar todos los campos con datos válidos."
                showDialog = true
            }

        }

        CustomSpacer()

        CustomText(viewModelD.state.value.imcResult)
        CustomText(viewModelD.state.value.imcEstado)

        CustomSpacer()
        CustomButton(
            text = "Guardar", modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp
                )
        ) {
            viewModel.updatePatient(
                patientId,
                viewModelD.state.value.edad.toIntOrNull(),
                viewModelD.state.value.imcResult,
                selectedIndex,
                viewModelD.state.value.imcEstado
            )
            navController.navigate("home")
        }
    }
}