package ie.setu.artisan1.ui.screens.record

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.room.RoomRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class RecordViewModel @Inject constructor(
    private val repository: RoomRepository
) : ViewModel() {
    private val _products = MutableStateFlow<List<ArtisanModel>>(emptyList())
    val uiProducts: StateFlow<List<ArtisanModel>> = _products.asStateFlow()

    private val _selectedSortOption = MutableStateFlow("Newest")
    val selectedSortOption: StateFlow<String> = _selectedSortOption.asStateFlow()

    private val _selectedCategories = MutableStateFlow<Set<String>>(emptySet())
    val selectedCategories: StateFlow<Set<String>> = _selectedCategories.asStateFlow()

    private val _priceRange = MutableStateFlow(0f..100f)
    val priceRange: StateFlow<ClosedFloatingPointRange<Float>> = _priceRange.asStateFlow()

    private val _fontSize = MutableStateFlow(16.sp) // 🔹 Default font size
    val fontSize: StateFlow<TextUnit> = _fontSize.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect { listOfProducts ->
                _products.value = sortAndFilterProducts(listOfProducts)
            }
        }
    }

    fun setSortOption(sortOption: String) {
        _selectedSortOption.value = sortOption
        updateProductList()
    }

    fun toggleCategorySelection(category: String) {
        _selectedCategories.value = if (_selectedCategories.value.contains(category)) {
            _selectedCategories.value - category
        } else {
            _selectedCategories.value + category
        }
        updateProductList()
    }

    fun setPriceRange(range: ClosedFloatingPointRange<Float>) {
        _priceRange.value = range
        updateProductList()
    }

    private fun updateProductList() {
        viewModelScope.launch {
            repository.getAll().collect { listOfProducts ->
                _products.value = sortAndFilterProducts(listOfProducts)
            }
        }
    }

    private fun sortAndFilterProducts(items: List<ArtisanModel>): List<ArtisanModel> {
        val filteredProducts = items.filter { item ->
            (_selectedCategories.value.isEmpty() || _selectedCategories.value.contains(item.category)) &&
                    (item.price in _priceRange.value)
        }

        return when (_selectedSortOption.value) {
            "Price Low to High" -> filteredProducts.sortedBy { it.price }
            "Price High to Low" -> filteredProducts.sortedByDescending { it.price }
            "Rating" -> filteredProducts.sortedByDescending { it.rating }
            "Newest" -> filteredProducts.sortedByDescending { it.dateAdded }
            "Oldest" -> filteredProducts.sortedByDescending { it.dateAdded }
            else -> filteredProducts
        }
    }

    private var lastDeletedProduct: ArtisanModel? = null

    fun deleteProduct(product: ArtisanModel) {
        viewModelScope.launch {
            lastDeletedProduct = product // 🔹 Store last deleted item
            repository.delete(product)
            updateProductList()
        }
    }

    fun updateProduct(updatedProduct: ArtisanModel) {
        viewModelScope.launch {
            repository.update(updatedProduct) // 🔹 Update item in database

            _products.update { list ->
                list.map { if (it.id == updatedProduct.id) updatedProduct else it } // 🔹 Apply changes to UI
            }
        }
    }



    fun undoSwipeAction() {
        viewModelScope.launch {
            lastDeletedProduct?.let {
                repository.insert(it) // 🔹 Restore deleted item
                lastDeletedProduct = null
                updateProductList()
            }
        }
    }

    fun setFontSize(size: Float) { // 🔹 Now correctly placed!
        _fontSize.value = size.sp // 🔹 Update font size dynamically
    }
}


/*    fun undoSwipeAction() {
        viewModelScope.launch {
            lastDeletedProduct?.let {
                repository.insert(it) // 🔹 Restore deleted item
                lastDeletedProduct = null

                _products.value = repository.getAll().first() // 🔹 Force UI refresh
            }
        }
    }*/