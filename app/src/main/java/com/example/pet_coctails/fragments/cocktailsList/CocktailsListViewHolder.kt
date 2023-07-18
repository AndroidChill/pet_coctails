package com.example.pet_coctails.fragments.cocktailsList

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pet_coctails.databinding.ItemCocktailBinding

class CocktailsListViewHolder (private val binding: ItemCocktailBinding): RecyclerView.ViewHolder(binding.root) {

    fun itemCocktail (imageLink: String, cocktailName: String, id: String, category: String, cocktailType: String, glassType: String){
        with(binding){
            ivCocktail.load (imageLink)
            tvName.text = "Cocktail name: $cocktailName"
            tvId.text = "Cocktail id: $id"
            tvCategory.text = "Cocktail category: $category"
            tvCocktailType.text = "Cocktail type: $cocktailType"
            tvGlassType.text = "Glass type: $glassType"
        }
    }
}