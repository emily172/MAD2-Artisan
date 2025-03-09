package ie.setu.artisan1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import kotlin.random.Random

@Entity
data class ArtisanModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val itemType: String = "N/A",
    val itemAmount: Int = 0,
    val description: String = "Item Description",
    val dateAdded: Date = Date(),
    val price: Double = 0.0,
    val category: String = "N/A",
    val rating: Float = 0.0f,
    val availability: Boolean = true
)

val fakeItems = List(30) { i ->
    ArtisanModel(
        id = 12345 + i, // Ensure ID is unique
        itemType = "Soap $i",
        itemAmount = i,
        description = "Description $i",
        dateAdded = Date()
    )
}
