package ie.setu.artisan1.data

import java.util.Date
import kotlin.random.Random

data class ArtisanModel(val id: Int = Random.nextInt(1, 100000),
                        val itemType: String = "N/A",
                        val itemAmount: Int = 0,
                        val description: String = "Item Description",
                        val dateAdded: Date = Date()
)

val fakeItems = List(30) { i ->
    ArtisanModel(id = 12345 + i,
        "Soap $i",
        i.toInt(),
        "Description $i",
        Date()
    )
}

