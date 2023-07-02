package com.example.pet_coctails.fragments.coctailsList

import androidx.recyclerview.widget.RecyclerView
import com.example.pet_coctails.databinding.ItemCocktailBinding

class CocktailsViewHolder (private val binding: ItemCocktailBinding): RecyclerView.ViewHolder(binding.root) {

    fun itemCocktail (imageLink: Int, cocktailName: String, id: Int, category: String, cocktailType: String, glassType: String){
        with(binding){
            ivCocktail.setImageResource(imageLink)
            tvName.text = cocktailName
            tvId.text = id.toString()
            tvCategory.text = category
            tvCocktailType.text = cocktailType
            tvGlassType.text = glassType
        }
    }
}