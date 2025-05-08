package ie.setu.artisan1.ui.screens.record

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

    private val _selectedCategory = MutableStateFlow<String?>(null)
    val selectedCategory: StateFlow<String?> = _selectedCategory.asStateFlow()

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

    fun setCategoryFilter(category: String?) {
        _selectedCategory.value = category
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
            (_selectedCategory.value == null || item.category == _selectedCategory.value)
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

    fun deleteProduct(product: ArtisanModel) {
        viewModelScope.launch {
            repository.delete(product)
            updateProductList() // Ensure UI updates after deletion
        }
    }
}
