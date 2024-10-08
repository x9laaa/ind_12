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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.bootcamp.ind12.components.CustomButton
import cl.bootcamp.ind12.components.CustomOutlinedTextField
import cl.bootcamp.ind12.components.CustomSpacer
import cl.bootcamp.ind12.components.CustomText
import cl.bootcamp.ind12.components.SegmentedButtonSingleSelect
import cl.bootcamp.ind12.viewmodal.IMCViewModel

@Preview
@Composable
fun HomeView() {
    val viewModelD: IMCViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var showDialog by remember { mutableStateOf(false) } // Controlar la visibilidad del AlertDialog

        // Mostrar el AlertDialog al iniciar
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("¡CUIDADO!") },
                text = { Text("No te olvides de llenar todos los campos con los datos solicitados.") },
                confirmButton = {
                    TextButton(onClick =  { showDialog = false }) {
                        Text("Entendido")
                    }
                }
            )
        }

        CustomText("Calculadora de IMC")
        SegmentedButtonSingleSelect()
        CustomSpacer()

        val focusManager = LocalFocusManager.current

        CustomOutlinedTextField(
            label = "Edad (Años)",
            value = viewModelD.state.value.edad,
            onValueChange = {viewModelD.updateEdad(it) },
            focusManager = focusManager
        )
        CustomSpacer()
        CustomOutlinedTextField(
            label = "Peso (Kg)",
            value = viewModelD.state.value.peso,
            onValueChange = {viewModelD.updatePeso(it)},
            focusManager = focusManager
        )
        CustomSpacer()
        CustomOutlinedTextField(
            label = "Altura (Cm)",
            value = viewModelD.state.value.alto,
            onValueChange = {viewModelD.updateAlto(it) },
            focusManager = focusManager
        )
        CustomSpacer()

        CustomButton(
            text = "Calcular",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp
                )
        ) {
            viewModelD.calculateIMC()
            showDialog = true

        }

        CustomSpacer()

        CustomText(String.format("%.1f", viewModelD.state.value.imcResult))
    }
}