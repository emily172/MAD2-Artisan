package ie.setu.artisan1.ui.screens.item

import ItemButton
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.components.item.AmountPicker
import ie.setu.artisan1.ui.components.item.AvailabilityField
import ie.setu.artisan1.ui.components.item.CategoryField
import ie.setu.artisan1.ui.components.item.HomeText
import ie.setu.artisan1.ui.components.item.ItemDescription
import ie.setu.artisan1.ui.components.item.ItemInventory
import ie.setu.artisan1.ui.components.item.PriceField
import ie.setu.artisan1.ui.components.item.RadioButtonGroup
import ie.setu.artisan1.ui.components.item.RatingField
import ie.setu.artisan1.ui.screens.record.RecordViewModel
import ie.setu.artisan1.ui.theme.Artisan1Theme

@Composable
fun ItemScreen(
    modifier: Modifier = Modifier,
    recordViewModel: RecordViewModel = hiltViewModel()
) {
    val products = recordViewModel.uiProducts.collectAsState().value

    var itemType by remember { mutableStateOf("Soap") }
    var itemAmount by remember { mutableIntStateOf(10) }
    var itemDescription by remember { mutableStateOf("Add an item description!") }
    //New Categories
    var itemPrice by remember { mutableStateOf(0.0) }
    var itemCategory by remember { mutableStateOf("N/A") }
    var itemRating by remember { mutableStateOf(0.0f) }
    var itemAvailability by remember { mutableStateOf(true) }
    var totalItems by remember { mutableIntStateOf(0) }

    totalItems = products.sumOf { it.itemAmount }

    Column {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
        ) {
            HomeText()
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButtonGroup(
                    modifier = modifier,
                    onCategoryChange = { itemType = it }
                )
                Spacer(modifier.weight(1f))
                AmountPicker(
                    onCategoryChange = { itemAmount = it }
                )
            }
            ItemInventory(
                modifier = modifier,
                totalItems = totalItems
            )
            //New Categories
            PriceField(
                price = itemPrice,
                onPriceChange = { itemPrice = it }
            )
            CategoryField(
                category = itemCategory,
                onCategoryChange = { itemCategory = it }
            )
            RatingField(
                rating = itemRating,
                onRatingChange = { itemRating = it }
            )
            AvailabilityField(
                availability = itemAvailability,
                onAvailabilityChange = { itemAvailability = it }
            )
            ItemDescription(
                modifier = modifier,
                onDescriptionChange = { itemDescription = it }
            )
            //New Categories
            ItemButton(
                modifier = modifier,
                product = ArtisanModel(
                    itemType = itemType,
                    itemAmount = itemAmount,
                    description = itemDescription,
                    price = itemPrice,
                    category = itemCategory,
                    rating = itemRating,
                    availability = itemAvailability
                ),
                onTotalItemsChange = { totalItems = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemScreenPreview() {
    Artisan1Theme {
        PreviewItemScreen(
            modifier = Modifier,
            products = fakeItems.toMutableStateList()
        )
    }
}

@Composable
fun PreviewItemScreen(
    modifier: Modifier = Modifier,
    products: SnapshotStateList<ArtisanModel>
) {
    var itemType by remember { mutableStateOf("Soap") }
    var itemAmount by remember { mutableIntStateOf(10) }
    var itemDescription by remember { mutableStateOf("Add an item description!") }
    //New Categories
    var itemPrice by remember { mutableStateOf(0.0) }
    var itemCategory by remember { mutableStateOf("N/A") }
    var itemRating by remember { mutableStateOf(0.0f) }
    var itemAvailability by remember { mutableStateOf(true) }
    var totalItems by remember { mutableIntStateOf(0) }

    totalItems = products.sumOf { it.itemAmount }

    Column {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
        ) {
            HomeText()
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButtonGroup(
                    modifier = modifier,
                    onCategoryChange = { itemType = it }
                )
                Spacer(modifier.weight(1f))
                AmountPicker(
                    onCategoryChange = { itemAmount = it }
                )
            }
            ItemInventory(
                modifier = modifier,
                totalItems = totalItems
            )
            //New Categories
            PriceField(
                price = itemPrice,
                onPriceChange = { itemPrice = it }
            )
            CategoryField(
                category = itemCategory,
                onCategoryChange = { itemCategory = it }
            )
            RatingField(
                rating = itemRating,
                onRatingChange = { itemRating = it }
            )
            AvailabilityField(
                availability = itemAvailability,
                onAvailabilityChange = { itemAvailability = it }
            )
            ItemDescription(
                modifier = modifier,
                onDescriptionChange = { itemDescription = it }
            )
            //New Categories
            ItemButton(
                modifier = modifier,
                product = ArtisanModel(
                    itemType = itemType,
                    itemAmount = itemAmount,
                    description = itemDescription,
                    price = itemPrice,
                    category = itemCategory,
                    rating = itemRating,
                    availability = itemAvailability
                ),
                onTotalItemsChange = { totalItems = it }
            )
        }
    }
}
