package ie.setu.artisan1.data.room

import ie.setu.artisan1.data.ArtisanModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class RoomRepository @Inject
constructor(private val artisanDAO: ArtisanDAO) {
    fun getAll(): Flow<List<ArtisanModel>>
            = artisanDAO.getAll()

    suspend fun insert(item: ArtisanModel)
    { artisanDAO.insert(item) }

    suspend fun update(item: ArtisanModel)
    { artisanDAO.update(item) }

    suspend fun delete(item: ArtisanModel)
    { artisanDAO.delete(item) }
}
