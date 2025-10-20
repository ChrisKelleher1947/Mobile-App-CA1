package org.wit.petcare.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.wit.petcare.R
import org.wit.petcare.databinding.ActivityPetRecordListBinding
import org.wit.petcare.main.MainApp
import org.wit.petcare.adapters.PetcareAdapter
import org.wit.petcare.adapters.PetCareListener
import org.wit.petcare.models.PetCareModel


class PetRecordListActivity : AppCompatActivity(), PetCareListener  {

    lateinit var app: MainApp
    private lateinit var binding: ActivityPetRecordListBinding

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0,app.petRecords.findAll().size)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetRecordListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = PetcareAdapter(app.petRecords.findAll(), this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, PetCareActivity::class.java)
                getResult.launch(launcherIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPetRecordClick(petrecord: PetCareModel) {
        val launcherIntent = Intent(this, PetRecordDetailActivity::class.java)
        launcherIntent.putExtra("pet_record", petrecord)
        startActivity(launcherIntent)
    }

    private val getClickResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0,app.petRecords.findAll().size)
            }
        }
    override fun onResume() {
        super.onResume()
        binding.recyclerView.adapter = PetcareAdapter(app.petRecords.findAll(), this)
    }

}
