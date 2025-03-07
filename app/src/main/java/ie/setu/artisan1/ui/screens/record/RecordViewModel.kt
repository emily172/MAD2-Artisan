package ie.setu.artisan1.ui.screens.record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.room.RoomRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class RecordViewModel @Inject
constructor(private val repository: RoomRepository) : ViewModel() {
    private val _products
            = MutableStateFlow<List<ArtisanModel>>(emptyList())
    val uiProducts: StateFlow<List<ArtisanModel>>
            = _products.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect { listOfProducts ->
                _products.value = listOfProducts
            }
        }
    }
    fun deleteProduct(product: ArtisanModel) {
        viewModelScope.launch {
            repository.delete(product)
        }
    }
}

