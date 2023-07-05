package com.example.pet_coctails.fragments.coctailsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pet_coctails.databinding.ItemCocktailBinding

class CocktailsAdapter (val listener : Listener) : RecyclerView.Adapter<CocktailsViewHolder>() {

    private val data = mutableListOf<CocktailsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCocktailBinding = ItemCocktailBinding.inflate(layoutInflater, parent, false)
        return CocktailsViewHolder(binding)
    }

    fun addData (dataTemp: List<CocktailsData>){
        val prevCount = data.size
        data.clear()
        notifyItemRangeRemoved(0,prevCount)
        data.addAll(dataTemp)
        notifyItemRangeInserted(0, dataTemp.size)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CocktailsViewHolder, position: Int) {
        data[position].apply {
            holder.itemCocktail(this.imageLink, this.cocktailName, this.id, this.category, this.cocktailType, this.glassType, this.info, listener)
        }

    }

    interface Listener {
        fun onClick (cocktails : CocktailsViewHolder)
    }

}