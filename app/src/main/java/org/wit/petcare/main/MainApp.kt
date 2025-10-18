package org.wit.petcare.main

import android.app.Application
import org.wit.petcare.models.PetCareModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val petRecords = ArrayList<PetCareModel>()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("PetCare started")
        print("fixing github")
    }
}