package org.wit.petcare.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.wit.petcare.R
import org.wit.petcare.main.MainApp

class PetRecordListActivity : AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_record_list)
        app = application as MainApp
    }
}
