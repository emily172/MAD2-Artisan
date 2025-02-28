package ie.setu.artisan1.ui.components.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ie.setu.artisan1.ui.theme.Artisan1Theme
import ie.setu.artisan1.R

@Composable
fun HomeText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            top = 10.dp,
            bottom = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.Artisan),
            fontWeight = FontWeight.Thin,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize, // Dynamic scaling - adjusts for text scaling
            color = MaterialTheme.colorScheme.onSurface // Theme-aware color - adjusts for light or dark theme
        )
        Text(
            text = stringResource(R.string.artisanSubtitle),
            fontWeight = FontWeight.Light,
            fontSize = MaterialTheme.typography.titleLarge.fontSize, // Dynamic scaling
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Artisan1Theme {
        HomeText()
    }
}
