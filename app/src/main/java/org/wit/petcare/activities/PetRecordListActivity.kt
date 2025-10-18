package org.wit.petcare.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.wit.petcare.R
import org.wit.petcare.databinding.ActivityPetRecordListBinding
import org.wit.petcare.databinding.CardPetRecordBinding
import org.wit.petcare.main.MainApp
import org.wit.petcare.models.PetCareModel


class PetRecordListActivity : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityPetRecordListBinding

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.notifyItemRangeChanged(0, app.petRecords.size)
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
        binding.recyclerView.adapter = PetcareAdapter(app.petRecords)
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
}


class PetcareAdapter constructor(private var petrecords: List<PetCareModel>) :
    RecyclerView.Adapter<PetcareAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardPetRecordBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val petrecord = petrecords[holder.adapterPosition]
        holder.bind(petrecord)
    }

    override fun getItemCount(): Int = petrecords.size

    class MainHolder(private val binding : CardPetRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(petrecord: PetCareModel) {
            binding.petcareTitle.text = petrecord.petName
            binding.description.text = petrecord.petType
        }
    }
}
