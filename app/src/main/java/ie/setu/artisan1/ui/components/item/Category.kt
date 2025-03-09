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
fun CategoryField(
    category: String,
    onCategoryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = category,
        onValueChange = onCategoryChange,
        label = { Text(text = stringResource(R.string.category)) },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun CategoryFieldPreview() {
    Artisan1Theme {
        CategoryField(
            category = "Cosmetics",
            onCategoryChange = {}
        )
    }
}
