package ie.setu.artisan1.ui.components.record


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PriceRangeSlider(
    priceRange: ClosedFloatingPointRange<Float>,
    onPriceRangeChanged: (ClosedFloatingPointRange<Float>) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Price Range: ${priceRange.start.toInt()} - ${priceRange.endInclusive.toInt()} €")

        RangeSlider(
            value = priceRange,
            onValueChange = { newRange -> onPriceRangeChanged(newRange) },
            valueRange = 0f..500f, // Main to Max price range
            steps = 10
        )
    }
}
