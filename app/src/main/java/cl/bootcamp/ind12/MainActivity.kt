package cl.bootcamp.ind12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.ind12.ui.theme.Ind12Theme
import cl.bootcamp.ind12.view.ImcView
import cl.bootcamp.ind12.view.PatientsView
import cl.bootcamp.ind12.viewmodal.PatientsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ind12Theme {
                val patientsViewModel: PatientsViewModel = viewModel()
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home" ){
                    composable(route = "home") { PatientsView(navController,viewModel = patientsViewModel)}
                    composable(route = "imc") {ImcView(navController)}
                }
            }
        }
    }
}