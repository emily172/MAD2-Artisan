package ie.setu.artisan1.ui.components.record

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Will be adding more categories based on the item card already created
fun getCategoryColor(category: String): Color {
    return when (category) {
        "All" -> Color(0xFFD70074) // Dark Pink representing the application
        "Soap" -> Color(0xFFA7D8FF) // Light blue for freshness
        "Candle" -> Color.Cyan // Light blue
        "Textile" -> Color(0xFF800040) // Mahogany for natural fabrics
        "Pottery" -> Color(0xFF8B4513) // Earthy brown for ceramics
        "Jam" -> Color(0xFFDC143C) // Berry preserves flavour
        "Weaving" -> Color(0xFF4682B4) // Steel shade blue for material
        "Painting" -> Color(0xFFFA8072) // Salmon tone with artistic taste
        "Jewellery" -> Color(0xFFFFD792) // Bright yellow for jewels
        "Organic" -> Color(0xFF6B8E23) // Fresh green and nature
        "Bubbly" -> Color(0xFFB9F2FF) // Clear ice blue
        "Vegan" -> Color(0xFF228B22) // Representing plant based products
        "Homemade" -> Color(0xFFD2691E) // Homely and cozy
        "Jelly" -> Color(0xFF800080) // Vibrant and strong
        "Diamond" -> Color(0xFFB9F2FF) // Ice blue, elegant and luxurious
        "Home" -> Color(0xFFFFE4B5) // Welcoming
        "Sew" -> Color(0xFFDB7093) // Delicate pale rose
        "Knit", -> Color(0xFFB22222) // Warm
        "Fruit" -> Color(0xFFFF4500) // Juicy
        "N/A" -> Color(0xFF808080) // No category



        else -> Color.Gray // Default color for uncategorized items
    }
}



@Composable
fun CategoryTag(
    category: String,
    onRemove: () -> Unit
) {
    AssistChip(
        onClick = { onRemove() },
        label = { Text(category, fontSize = 14.sp) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Remove",
                modifier = Modifier.clickable { onRemove() }
            )
        },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = getCategoryColor(category)
        ),
        shape = RoundedCornerShape(8.dp), // 🔹 Soft rounded edges for a modern look
        elevation = AssistChipDefaults.assistChipElevation(
            pressedElevation = 2.dp // 🔹 Reduces elevation when pressed for realism
        ),
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
    )
}


