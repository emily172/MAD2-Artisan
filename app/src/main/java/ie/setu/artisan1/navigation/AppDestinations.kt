package ie.setu.artisan1.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.ui.graphics.vector.ImageVector

interface AppDestination {
    val icon: ImageVector
    val label: String
    val route: String
}

object Record : AppDestination {
    override val icon = Icons.AutoMirrored.Filled.List
    override val label = "Record"
    override val route = "record"
}

object Item : AppDestination {
    override val icon = Icons.Filled.AddCircle
    override val label = "Item"
    override val route = "item"
}

val bottomAppBarDestinations = listOf(Item, Record)
val allDestinations = listOf(Record, Item)
