package cl.bootcamp.ind12.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.ind12.view.ImcView
import cl.bootcamp.ind12.view.PatientsView
import cl.bootcamp.ind12.viewmodal.PatientsViewModel

@Composable
fun navView(){
    val patientsViewModel: PatientsViewModel = viewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home" ){
        composable(route = "home") { PatientsView(navController,viewModel = patientsViewModel) }
        composable("imc/{patientId}") { backStackEntry ->
            val patientId = backStackEntry.arguments?.getString("patientId")
            ImcView(navController,patientId = patientId,viewModel = patientsViewModel)
        }
    }

}