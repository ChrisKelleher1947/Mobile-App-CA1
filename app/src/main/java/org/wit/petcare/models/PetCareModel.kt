package org.wit.petcare.models
import kotlinx.serialization.Serializable

@Serializable
data class PetCareModel(
    var petName: String = "",
    var petType: String = "",
    var petBirthday: String = ""
)