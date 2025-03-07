package ie.setu.artisan1.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ie.setu.artisan1.data.ArtisanModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ArtisanDAO {
    @Query("SELECT * FROM artisanmodel WHERE id=:id")
    fun get(id: Int): Flow<ArtisanModel>

    @Query("SELECT * FROM artisanmodel")
    fun getAll(): Flow<List<ArtisanModel>>

    @Insert
    suspend fun insert(item: ArtisanModel)

    @Query("UPDATE artisanmodel SET description=:message WHERE id = :id")
    suspend fun update(id: Int, message: String)

    @Delete
    suspend fun delete(item: ArtisanModel)
}
