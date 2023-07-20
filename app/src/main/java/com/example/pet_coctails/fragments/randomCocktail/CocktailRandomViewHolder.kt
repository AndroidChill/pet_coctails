package com.example.pet_coctails.fragments.randomCocktail

import androidx.recyclerview.widget.RecyclerView
import com.example.pet_coctails.databinding.ItemCocktailInfoBinding

class CocktailRandomViewHolder (private val binding: ItemCocktailInfoBinding): RecyclerView.ViewHolder(binding.root) {
    fun itemCocktailInfo (ingredient: String, measure: String){
        with(binding){
            tvIngredient.text = ingredient
            tvMeasure.text = measure
        }
    }
}