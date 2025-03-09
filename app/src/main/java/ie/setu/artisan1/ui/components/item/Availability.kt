package ie.setu.artisan1.ui.components.item

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ie.setu.artisan1.R
import ie.setu.artisan1.ui.theme.Artisan1Theme
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AvailabilityField(
    availability: Boolean,
    onAvailabilityChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp)
    ) {
        Text(text = stringResource(R.string.availability))
        Spacer(modifier = Modifier.width(8.dp))
        Checkbox(
            checked = availability,
            onCheckedChange = onAvailabilityChange
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AvailabilityFieldPreview() {
    Artisan1Theme {
        AvailabilityField(
            availability = true,
            onAvailabilityChange = {}
        )
    }
}
