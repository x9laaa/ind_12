package cl.bootcamp.ind12.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SegmentedButtonSingleSelect(
    selectedIndex: Int, onSelectedIndexChange: (Int) -> Unit
) {
    val options = listOf("Hombres", "Mujeres")

    SingleChoiceSegmentedButtonRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                onClick = { onSelectedIndexChange(index) },
                selected = index == selectedIndex,
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = Color.DarkGray,
                    activeContentColor = Color.White,     // Color del texto o contenido cuando está seleccionado
                    inactiveContentColor = Color.Black
                )
            ) {
                Text(label)
            }
        }
    }

}
