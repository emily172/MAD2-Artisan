package ie.setu.artisan1.ui.components.record

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.ui.unit.sp

@Composable
fun SortFilterDropdown(
    selectedSortOption: String,
    onSortOptionSelected: (String) -> Unit,
    selectedCategories: Set<String>,
    onCategoryToggled: (String) -> Unit
) {
    var expandedSort by remember { mutableStateOf(false) }
    var expandedCategory by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(8.dp)) {
        // Sorting Dropdown
        Box {
            Button(onClick = { expandedSort = !expandedSort },modifier = Modifier.height(36.dp)) {
                Text(text = selectedSortOption)  // Adding in the text parameter
                Icon(imageVector = Icons.Filled.ArrowCircleDown, contentDescription = "Sort Options")
            }

            DropdownMenu(expanded = expandedSort, onDismissRequest = { expandedSort = false }) {
                listOf("Price Low to High", "Price High to Low", "Rating", "Newest", "Oldest").forEachIndexed { index, option ->
                    AnimatedVisibility(
                        visible = expandedSort,
                        enter = slideInVertically(
                            initialOffsetY = { it * index },
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy, // 🔹 Creates bounce effect
                                stiffness = Spring.StiffnessLow // 🔹 Smooth movement
                            )
                        ),
                        exit = slideOutVertically(targetOffsetY = { it * index })
                    ) {
                        DropdownMenuItem(
                            text = { Text(option, fontSize = 12.sp) },  // Adding in the text parameter
                            onClick = { onSortOptionSelected(option); expandedSort = false }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Category Filtering Dropdown
        Box {
            Button(onClick = { expandedCategory = !expandedCategory }) {
                Text(text = if (selectedCategories.isEmpty()) "All Categories" else selectedCategories.joinToString(", "))
                Icon(imageVector = Icons.Filled.ArrowCircleDown, contentDescription = "Category Options")
            }

            DropdownMenu(expanded = expandedCategory, onDismissRequest = { expandedCategory = false }) {
                listOf("All","Soap", "Candle", "Jam","Pottery","Weaving","Painting","Textile","Jewellery","Bubbly","Vegan", "N/A",  ).forEachIndexed { index, option ->
                    AnimatedVisibility(
                        visible = expandedCategory,
                        enter = slideInVertically(
                            initialOffsetY = { it * index },
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        ),
                        exit = slideOutVertically(targetOffsetY = { it * index })
                    ) {
                        DropdownMenuItem(
                            text = { Text(option, fontSize = 12.sp) },
                            onClick = { onCategoryToggled(option) }
                        )
                    }
                }
            }
        }
    }
}



