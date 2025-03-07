package ie.setu.artisan1.data.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ie.setu.artisan1.data.room.AppDatabase
import ie.setu.artisan1.data.room.ArtisanDAO
import ie.setu.artisan1.data.room.RoomRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context):
            AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "artisan_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideArtisanDAO(appDatabase: AppDatabase):
            ArtisanDAO = appDatabase.getArtisanDAO()

    @Provides
    fun provideRoomRepository(artisanDAO: ArtisanDAO):
            RoomRepository = RoomRepository(artisanDAO)
}
