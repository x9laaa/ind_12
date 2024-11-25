package cl.bootcamp.ind12.view.onBoardingViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ButtonFinnish(currentPage: Int, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPage != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPage == 2) {
            OutlinedButton(
                onClick = { navController.navigate("home")},
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Blue, // Color de fondo
                    contentColor = Color.White   // Color del texto y del borde
                )
            ) {
                Text(
                    text = "Entrar",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp)
                )
            }
        }
    }
}
