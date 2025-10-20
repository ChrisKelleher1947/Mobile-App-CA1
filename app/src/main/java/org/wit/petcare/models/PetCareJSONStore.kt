package org.wit.petcare.models

import android.content.Context
import kotlinx.serialization.json.Json
import timber.log.Timber
import java.io.File

class PetCareJSONStore(private val context: Context) {

    private val fileName = "pets.json"
    private var petRecords = mutableListOf<PetCareModel>()
    private val json = Json

    init {
        if (File(context.filesDir, fileName).exists()) {
            load()
        }
    }

    fun findAll(): List<PetCareModel> = petRecords

    fun create(pet: PetCareModel) {
        petRecords.add(pet)
        save()
    }

    fun update() {
        save()
    }

    fun delete(pet: PetCareModel) {
        petRecords.remove(pet)
        save()
    }

    private fun save() {
        try {
            val jsonString = json.encodeToString(petRecords)
            File(context.filesDir, fileName).writeText(jsonString)
            Timber.i("Saved ${petRecords.size} pets to JSON")
        } catch (e: Exception) {
            Timber.e("Error saving pets: ${e.message}")
        }
    }

    private fun load() {
        try {
            val jsonString = File(context.filesDir, fileName).readText()
            petRecords = json.decodeFromString(jsonString)
            Timber.i("Loaded ${petRecords.size} pets from JSON")
        } catch (e: Exception) {
            Timber.e("Error loading pets: ${e.message}")
        }
    }
}
