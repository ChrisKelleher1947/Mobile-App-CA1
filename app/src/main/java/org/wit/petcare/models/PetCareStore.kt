package org.wit.petcare.models

interface PlacemarkStore {
    fun findAll(): List<PetCareModel>
    fun create(placemark: PetCareModel)
    fun update(placemark: PetCareModel)
}