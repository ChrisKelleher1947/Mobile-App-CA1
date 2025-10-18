package org.wit.petcare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.petcare.databinding.CardPetRecordBinding
import org.wit.petcare.models.PetCareModel

interface PetCareListener {
    fun onPetRecordClick(petrecord: PetCareModel)
}
class PetcareAdapter (private var petrecords: List<PetCareModel>,
                      private val listener: PetCareListener) :
    RecyclerView.Adapter<PetcareAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardPetRecordBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val petrecord = petrecords[holder.adapterPosition]
        holder.bind(petrecord, listener)
    }

    override fun getItemCount(): Int = petrecords.size

    class MainHolder(private val binding : CardPetRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(petrecord: PetCareModel, listener: PetCareListener) {
            binding.petcareTitle.text = petrecord.petName
            binding.description.text = petrecord.petType
            binding.root.setOnClickListener { listener.onPetRecordClick(petrecord)}
        }
    }
}