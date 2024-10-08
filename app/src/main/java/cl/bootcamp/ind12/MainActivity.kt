package cl.bootcamp.ind12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.bootcamp.ind12.ui.theme.Ind12Theme
import cl.bootcamp.ind12.view.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ind12Theme {
                HomeView()
            }
        }
    }
}

