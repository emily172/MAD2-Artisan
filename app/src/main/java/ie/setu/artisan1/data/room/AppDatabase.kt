package ie.setu.artisan1.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ie.setu.artisan1.data.ArtisanModel

@Database(entities = [ArtisanModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getArtisanDAO(): ArtisanDAO
}

