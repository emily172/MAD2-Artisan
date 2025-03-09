package ie.setu.artisan1.ui.components.item

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.chargemap.compose.numberpicker.ListItemPicker
import ie.setu.artisan1.ui.theme.Artisan1Theme

@Composable
fun AmountPicker(
    onCategoryChange: (Int) -> Unit
) {
    val possibleValues = listOf("10", "20", "30", "40", "50", "60","70","80","90","100")
    var pickerValue by remember { mutableStateOf(possibleValues[0]) }

    ListItemPicker(
        label = { it },
        dividersColor = MaterialTheme.colorScheme.primary,
        // Updated colour for applying dark mode
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp
        ),
        value = pickerValue,
        onValueChange = {
            pickerValue = it
            onCategoryChange(pickerValue.toInt())
        },
        list = possibleValues
    )
}

@Preview(showBackground = true)
@Composable
fun PickerPreview() {
    Artisan1Theme {
        AmountPicker(onCategoryChange = {})
    }
}
