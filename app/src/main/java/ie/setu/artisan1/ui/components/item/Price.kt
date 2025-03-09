package ie.setu.artisan1.ui.components.item
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ie.setu.artisan1.R
import ie.setu.artisan1.ui.theme.Artisan1Theme
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PriceField(
    price: Double,
    onPriceChange: (Double) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = price.toString(),
        onValueChange = { value ->
            val newValue = value.toDoubleOrNull() ?: 0.0
            onPriceChange(newValue)
        },
        label = { Text(text = stringResource(R.string.price)) },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun PriceFieldPreview() {
    Artisan1Theme {
        PriceField(
            price = 10.0,
            onPriceChange = {}
        )
    }
}
