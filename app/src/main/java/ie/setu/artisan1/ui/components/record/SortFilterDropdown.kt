package ie.setu.artisan1.ui.components.record

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleDown


@Composable
fun SortFilterDropdown(
    selectedSortOption: String,
    onSortOptionSelected: (String) -> Unit,
    selectedCategory: String?,
    onCategorySelected: (String?) -> Unit
) {
    var expandedSort by remember { mutableStateOf(false) }
    var expandedCategory by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Box {
            Button(onClick = { expandedSort = !expandedSort }) {
                Text(text = selectedSortOption)
                Icon(imageVector = Icons.Filled.ArrowCircleDown, contentDescription = "Sort Options")
            }
            DropdownMenu(expanded = expandedSort, onDismissRequest = { expandedSort = false }) {
                listOf("Price Low to High", "Price High to Low", "Rating", "Newest", "Oldest").forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) }, // Adding in the text parameter
                        onClick = { onSortOptionSelected(option); expandedSort = false }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box {
            Button(onClick = { expandedCategory = !expandedCategory }) {
                Text(text = selectedCategory ?: "All Categories")
                Icon(imageVector = Icons.Filled.ArrowCircleDown, contentDescription = "Category Options")
            }
            //Going to update this with the new categories created from the item card for better filtering
            DropdownMenu(expanded = expandedCategory, onDismissRequest = { expandedCategory = false }) {
                listOf("Soap", "Candle", "Jam","Pottery","Weaving","Painting","Jewellery","N/A", "Textile", "All").forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) }, // Adding in the text parameter
                        onClick = { onCategorySelected(if (option == "All") null else option); expandedCategory = false }
                    )
                }
            }
        }
    }
}


