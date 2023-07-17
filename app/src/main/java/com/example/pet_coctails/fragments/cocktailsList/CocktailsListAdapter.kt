package com.example.pet_coctails.fragments.cocktailsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pet_coctails.databinding.ItemCocktailBinding

class CocktailsListAdapter (private val onClick: (String) -> Unit) : RecyclerView.Adapter<CocktailsListViewHolder>() {

    private val data = mutableListOf<CocktailsListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailsListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCocktailBinding = ItemCocktailBinding.inflate(layoutInflater, parent, false)
        return CocktailsListViewHolder(binding)
    }

    fun addData (dataTemp: List<CocktailsListData>){
        val prevCount = data.size
        data.clear()
        notifyItemRangeRemoved(0,prevCount)
        data.addAll(dataTemp)
        notifyItemRangeInserted(0, dataTemp.size)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CocktailsListViewHolder, position: Int) {
        data[position].apply {
            holder.itemCocktail(this.imageLink, this.cocktailName, this.id, this.category, this.cocktailType, this.glassType)
        }
        
        holder.itemView.setOnClickListener {
            onClick(data[position].id)
        }

    }

}