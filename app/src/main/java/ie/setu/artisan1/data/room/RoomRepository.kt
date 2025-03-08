package ie.setu.artisan1.data.room

import ie.setu.artisan1.data.ArtisanModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class RoomRepository @Inject
constructor(private val artisanDAO: ArtisanDAO) {
    fun getAll(): Flow<List<ArtisanModel>>
            = artisanDAO.getAll()

    fun get(id: Int) = artisanDAO.get(id)


    suspend fun insert(product: ArtisanModel)
    { artisanDAO.insert(product) }

    suspend fun update(product: ArtisanModel)
    { artisanDAO.update(product.id,product.description) }


    suspend fun delete(product: ArtisanModel)
    { artisanDAO.delete(product) }
}
