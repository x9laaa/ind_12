package cl.bootcamp.ind12.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(text: String) {
    Text(
        text = text,
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold
    )
}