package cl.bootcamp.ind12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.bootcamp.ind12.navigation.navView
import cl.bootcamp.ind12.ui.theme.Ind12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ind12Theme {
                navView()
            }
        }
    }
}