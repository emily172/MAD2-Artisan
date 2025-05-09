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
        "Soap" -> Color(0xFFA7D8FF) // Light blue for freshness
        "Candle" -> Color.Cyan // Warm amber for cozy vibes
        "Textile" -> Color(0xFF800080) // Soft green for natural fabrics
        "Pottery" -> Color(0xFF8B4513) // Earthy brown for ceramics
        "Jam" -> Color(0xFFDC143C) // Earthy brown for ceramics
        "Weaving" -> Color(0xFFFA8072) // Soft green for natural fabrics
        "Painting" -> Color(0xFF795548) // Earthy brown for ceramics
        "Jewellery" -> Color(0xFFFFD700) // Earthy brown for ceramics
        "N/A" -> Color(0xFF808080) // Earthy brown for ceramics
        "All" -> Color(0xFFD70074) // Earthy brown for ceramics
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


