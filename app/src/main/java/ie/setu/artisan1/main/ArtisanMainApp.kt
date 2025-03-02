package ie.setu.artisan1.main

import android.app.Application
import timber.log.Timber


class ArtisanMainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i("Starting Artisan Application")

    }
}
