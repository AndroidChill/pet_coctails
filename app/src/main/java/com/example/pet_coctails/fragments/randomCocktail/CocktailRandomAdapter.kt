package com.example.pet_coctails.fragments.randomCocktail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pet_coctails.databinding.ItemCocktailInfoBinding
import com.example.pet_coctails.fragments.CocktailClear

class CocktailRandomAdapter : RecyclerView.Adapter<CocktailRandomViewHolder>() {

    private val data = mutableListOf<CocktailClear>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailRandomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCocktailInfoBinding = ItemCocktailInfoBinding.inflate(layoutInflater, parent, false)
        return CocktailRandomViewHolder(binding)
    }

    fun addData (dataTemp: List<CocktailClear>){
        val prevCount = data.size
        data.clear()
        notifyItemRangeRemoved(0,prevCount)
        data.addAll(dataTemp)
        notifyItemRangeInserted(0, dataTemp.size)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CocktailRandomViewHolder, position: Int) {
        data[position].apply {
            holder.itemCocktailInfo(this.ingredient, this.measure ?: "On your taste")
        }

    }
}