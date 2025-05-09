package ie.setu.artisan1.ui.screens.record

import ie.setu.artisan1.ui.theme.Artisan1Theme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.artisan1.R
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.components.record.SortFilterDropdown
import ie.setu.artisan1.ui.components.record.ItemCardList
import ie.setu.artisan1.ui.components.general.Centre
import ie.setu.artisan1.ui.components.record.CategoryTag
import ie.setu.artisan1.ui.components.record.PriceRangeSlider
import ie.setu.artisan1.ui.components.record.RecordText

@Composable
fun RecordScreen(
    modifier: Modifier = Modifier,
    onClickProductDetails: (Int) -> Unit,
    recordViewModel: RecordViewModel = hiltViewModel()
) {
    var searchQuery by remember { mutableStateOf("") }
    val selectedSortOption by recordViewModel.selectedSortOption.collectAsState()
    val selectedCategories by recordViewModel.selectedCategories.collectAsState()
    val priceRange by recordViewModel.priceRange.collectAsState()

    val filteredProducts = recordViewModel.uiProducts.collectAsState().value.filter {
        (selectedCategories.isEmpty() || selectedCategories.contains(it.category)) &&
                (searchQuery.isEmpty() || it.itemType.contains(searchQuery, ignoreCase = true) ||
                        it.description.contains(searchQuery, ignoreCase = true) ||
                        it.category.contains(searchQuery, ignoreCase = true)) &&
                (it.price in priceRange)
    }

    val sortedFilteredProducts = remember(filteredProducts, selectedSortOption) {
        when (selectedSortOption) {
            "Price Low to High" -> filteredProducts.sortedBy { it.price }
            "Price High to Low" -> filteredProducts.sortedByDescending { it.price }
            "Rating" -> filteredProducts.sortedByDescending { it.rating }
            "Newest" -> filteredProducts.sortedByDescending { it.dateAdded }
            "Oldest" -> filteredProducts.sortedBy { it.dateAdded }
            else -> filteredProducts
        }
    }

    Column {
        Column(modifier = modifier.padding(top = 48.dp, start = 24.dp, end = 24.dp)) {
            RecordText()

            // Sorting & Filtering Dropdown
            SortFilterDropdown(
                selectedSortOption = selectedSortOption,
                onSortOptionSelected = { recordViewModel.setSortOption(it) },
                selectedCategories = selectedCategories,
                onCategoryToggled = { recordViewModel.toggleCategorySelection(it) }
            )

            // Price Range Slider
            PriceRangeSlider(
                priceRange = priceRange,
                onPriceRangeChanged = { recordViewModel.setPriceRange(it) }
            )


            // **Category Tags Displayed with Colors**
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                selectedCategories.forEach { category ->
                    CategoryTag(
                        category = category,
                        onRemove = { recordViewModel.toggleCategorySelection(category) }
                    )
                }
            }

            // Search Bar
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search") },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )

            if (sortedFilteredProducts.isEmpty()) {
                Centre(Modifier.fillMaxSize()) {
                    Text(
                        text = "No items found",
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                ItemCardList(
                    products = sortedFilteredProducts,
                    onClickProductDetails = onClickProductDetails,
                    onDeleteProduct = { recordViewModel.deleteProduct(it) }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RecordScreenPreview() {
    Artisan1Theme {
        PreviewRecordScreen(
            modifier = Modifier,
            products = fakeItems.toMutableStateList()
        )
    }
}

@Composable
fun PreviewRecordScreen(
    modifier: Modifier = Modifier,
    products: SnapshotStateList<ArtisanModel>
) {
    Column {
        Column(
            modifier = modifier.padding(
                top = 48.dp,
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            RecordText()
            if (products.isEmpty())
                Centre(Modifier.fillMaxSize()) {
                    Text(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        lineHeight = 34.sp,
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.empty_list)
                    )
                }
            else
                ItemCardList(
                    products = products,
                    onDeleteProduct = {},
                    onClickProductDetails = {}
                )
        }
    }
}