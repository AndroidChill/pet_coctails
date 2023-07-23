package com.example.pet_coctails.fragments.cocktailsList

import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import com.example.pet_coctails.R
import com.example.pet_coctails.databinding.ItemCocktailBinding

class CocktailsListViewHolder(
    private val binding: ItemCocktailBinding,
    private val onClickFavourite: (String, Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    
    private var isSelect = false
    
    fun itemCocktail(
        imageLink: String,
        cocktailName: String,
        id: String,
        category: String,
        cocktailType: String,
        glassType: String,
        isHeart: Boolean
    ) {
        with(binding) {
            val request = ImageRequest.Builder(ivCocktail.context).data(imageLink)
                .target(onStart = { placeholder ->
                    ivCocktail.setImageDrawable(ivCocktail.context.getDrawable(R.drawable.loading_wait))
                }, onSuccess = { result ->
                    ivCocktail.setImageDrawable(result)
                }, onError = { error ->
                    ivCocktail.setImageDrawable(ivCocktail.context.getDrawable(R.drawable.ups_retry))
                }).build()
            
            val imageLoader = ImageLoader.Builder(ivCocktail.context).crossfade(true).build()
            
            imageLoader.enqueue(request)
            
            tvName.text = "Cocktail name: $cocktailName"
            tvId.text = "Cocktail id: $id"
            tvCategory.text = "Cocktail category: $category"
            tvCocktailType.text = "Cocktail type: $cocktailType"
            tvGlassType.text = "Glass type: $glassType"
            
            isSelect = !isHeart
            select()
            
            ivHeart.setOnClickListener {
                onClickFavourite(id, isSelect)
                select()
            }
        }
        
    }
    
    private fun select() {
        if (isSelect) {
            binding.ivHeart.setImageResource(R.drawable.heart_empty)
        } else {
            binding.ivHeart.setImageResource(R.drawable.heart_full)
        }
        isSelect = !isSelect
    }
}