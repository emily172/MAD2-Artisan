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
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.content.Context
import android.os.Build
import androidx.compose.ui.platform.LocalContext
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

    ShakeDetector(onShake = {
        recordViewModel.undoSwipeAction()
    }) // 🔹 Detect device shake

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
                    onDeleteProduct = { recordViewModel.deleteProduct(it) },
                )
            }
        }
    }
}

@Composable
fun ShakeDetector(onShake: () -> Unit) {
    val context = LocalContext.current
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    var lastShakeTime by remember { mutableStateOf(0L) }

    // 🔹 Dynamically adjust shake sensitivity based on the device
    val deviceSensitivity = if (Build.MODEL.contains("Pixel") || Build.MANUFACTURER.contains("Samsung")) {
        10 // 🔹 More sensitive for high-end devices
    } else {
        12 // 🔹 Standard sensitivity for most devices
    }

    DisposableEffect(Unit) {
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.let {
                    val acceleration = Math.sqrt(
                        (event.values[0] * event.values[0] +
                                event.values[1] * event.values[1] +
                                event.values[2] * event.values[2]).toDouble()
                    )

                    if (acceleration > deviceSensitivity) { // 🔹 Adaptive shake detection
                        val currentTime = System.currentTimeMillis()
                        if (currentTime - lastShakeTime > 1500) { // 🔹 Prevent multiple triggers
                            lastShakeTime = currentTime
                            onShake() // 🔹 Call undo function
                        }
                    }
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_UI)

        onDispose { sensorManager.unregisterListener(listener) }
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
                    onClickProductDetails = {},
                )
        }
    }
}