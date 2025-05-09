package ie.setu.artisan1.ui.components.record


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PriceRangeSlider(
    priceRange: ClosedFloatingPointRange<Float>,
    onPriceRangeChanged: (ClosedFloatingPointRange<Float>) -> Unit
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("Price Range: €${priceRange.start.toInt()} - €${priceRange.endInclusive.toInt()}", fontSize = 12.sp)

        RangeSlider(
            value = priceRange,
            onValueChange = { newRange -> onPriceRangeChanged(newRange) },
            valueRange = 0f..500f, // Main to Max price range
            steps = 10,
            modifier = Modifier.height(32.dp).padding(horizontal = 4.dp) // 🔹 Smaller slider size
        )
    }
}
