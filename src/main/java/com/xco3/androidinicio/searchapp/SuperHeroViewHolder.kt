package com.xco3.androidinicio.searchapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xco3.androidinicio.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvSuperName.text = superHeroItemResponse.name
        Picasso.get().load(superHeroItemResponse.superheroImage.url).into(binding.ivSuperH)
        binding.root.setOnClickListener { onItemSelected(superHeroItemResponse.id) }
    }
}