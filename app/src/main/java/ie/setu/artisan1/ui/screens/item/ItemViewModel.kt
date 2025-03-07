package ie.setu.artisan1.ui.screens.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.room.RoomRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


// All new stuff

@HiltViewModel
class ItemViewModel @Inject
constructor(private val repository: RoomRepository) : ViewModel() {

    fun insert(product: ArtisanModel)
            = viewModelScope.launch {
        repository.insert(product)
    }
}