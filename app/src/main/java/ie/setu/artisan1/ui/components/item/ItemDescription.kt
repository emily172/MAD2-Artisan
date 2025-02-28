package ie.setu.artisan1.ui.components.item

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ie.setu.artisan1.R
import ie.setu.artisan1.ui.theme.Artisan1Theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ItemDescription(
    modifier: Modifier = Modifier,
    onDescriptionChange: (String) -> Unit
) {

    var description by remember { mutableStateOf("") }

    OutlinedTextField(
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
        ),
        maxLines = 2,
        value = description,
        onValueChange = {
            description = it
            onDescriptionChange(description)
        },
        modifier = modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.description)) }
    )
}

@Preview(showBackground = true)
@Composable
fun DescriptionPreview() {
    Artisan1Theme {
        ItemDescription(
            Modifier,
            onDescriptionChange = {})
    }
}
