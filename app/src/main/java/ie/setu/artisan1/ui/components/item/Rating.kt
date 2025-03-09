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
fun RatingField(
    rating: Float,
    onRatingChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = rating.toString(),
        onValueChange = { value ->
            val newValue = value.toFloatOrNull() ?: 0.0f
            onRatingChange(newValue)
        },
        label = { Text(text = stringResource(R.string.rating)) },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun RatingFieldPreview() {
    Artisan1Theme {
        RatingField(
            rating = 4.5f,
            onRatingChange = {}
        )
    }
}
