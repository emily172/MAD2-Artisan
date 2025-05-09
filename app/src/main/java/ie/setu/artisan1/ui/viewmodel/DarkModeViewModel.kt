package ie.setu.artisan1.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DarkModeViewModel : ViewModel() {
    private val _isDarkMode = MutableStateFlow(false) // Default is Light Mode
    val isDarkMode = _isDarkMode.asStateFlow()

    fun toggleDarkMode() {
        _isDarkMode.value = !_isDarkMode.value // 🔹 Toggle between light & dark mode
    }
}
