package org.wit.petcare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.petcare.databinding.CardPetRecordBinding
import org.wit.petcare.models.PetCareModel

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