package ie.setu.artisan1.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Info
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

object About : AppDestination {
    override val icon = Icons.Filled.Info
    override val label = "About"
    override val route = "about"
}


val bottomAppBarDestinations = listOf(Item, Record,About)
val allDestinations = listOf(Record, Item, About)
