package org.wit.petcare.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.wit.petcare.databinding.ActivityPetcareBinding
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber
import timber.log.Timber.i
import org.wit.petcare.models.PetCareModel

class PetCareActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPetcareBinding
    var petRecord = PetCareModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate the layout using View Binding
        binding = ActivityPetcareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())
        i("PetCare Activity started..")

        binding.btnAddPet.setOnClickListener {
            // Get field values
            val name = binding.petName.text.toString().trim()
            val type = binding.petType.text.toString().trim()
            val age = binding.petAge.text.toString().trim()

            // Check all fields
            if (name.isNotEmpty() && type.isNotEmpty() && age.isNotEmpty()) {
                petRecord.petName = name
                petRecord.petType = type
                petRecord.petAge = age

                // Log full model when valid
                i("Add Button Pressed: $petRecord")

                Snackbar.make(it, "Pet saved successfully!", Snackbar.LENGTH_SHORT).show()
            }
            else {
                // Build a user-friendly error message
                val missingFields = mutableListOf<String>()
                if (name.isEmpty()) missingFields.add("name")
                if (type.isEmpty()) missingFields.add("type")
                if (age.isEmpty()) missingFields.add("age")

                val message = "Please enter: ${missingFields.joinToString(", ")}"
                Snackbar.make(it, message, Snackbar.LENGTH_LONG).show()
            }
        }
    }
}