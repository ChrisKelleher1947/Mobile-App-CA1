package org.wit.petcare.main

import android.app.Application
import org.wit.petcare.models.PetCareJSONStore
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    lateinit var petRecords: PetCareJSONStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("PetCare started")
        petRecords = PetCareJSONStore(applicationContext)
    }
}