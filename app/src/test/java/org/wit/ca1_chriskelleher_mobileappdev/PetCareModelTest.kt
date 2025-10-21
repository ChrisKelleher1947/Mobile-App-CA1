package org.wit.ca1_chriskelleher_mobileappdev
import org.wit.petcare.models.PetCareModel
import org.junit.Assert.*
import org.junit.Test

class PetCareModelTest {

    @Test
    fun testDefaultValues() {
        val pet = PetCareModel()
        assertEquals("", pet.petName)
        assertEquals("", pet.petType)
        assertEquals("", pet.petBirthday)
        assertEquals("", pet.notes)
        assertEquals(1, pet.feedingHour)
        assertEquals(0, pet.feedingMinute)
        assertEquals("AM", pet.timePicker)
    }

    @Test
    fun testCustomValues() {
        val pet = PetCareModel(
            petName = "Charlie",
            petType = "Dog",
            petBirthday = "01/01/2020",
            notes = "Eats twice a day",
            feedingHour = 8,
            feedingMinute = 30,
            timePicker = "PM"
        )

        assertEquals("Charlie", pet.petName)
        assertEquals("Dog", pet.petType)
        assertEquals("01/01/2020", pet.petBirthday)
        assertEquals("Eats twice a day", pet.notes)
        assertEquals(8, pet.feedingHour)
        assertEquals(30, pet.feedingMinute)
        assertEquals("PM", pet.timePicker)
    }
}
