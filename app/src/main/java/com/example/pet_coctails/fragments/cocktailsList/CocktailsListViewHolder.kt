package com.example.pet_coctails.fragments.cocktailsList

import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import com.example.pet_coctails.R
import com.example.pet_coctails.databinding.ItemCocktailBinding

class CocktailsListViewHolder (private val binding: ItemCocktailBinding): RecyclerView.ViewHolder(binding.root) {

    fun itemCocktail (imageLink: String, cocktailName: String, id: String, category: String, cocktailType: String, glassType: String){
        with(binding){
            val request = ImageRequest.Builder(ivCocktail.context)
                .data(imageLink)
                .target(
                    onStart = { placeholder ->
                        ivCocktail.setImageDrawable(ivCocktail.context.getDrawable(R.drawable.ic_launcher_foreground))
                    },
                    onSuccess = { result ->
                        ivCocktail.setImageDrawable(result)
                    },
                    onError = { error ->
                        // Handle the error drawable.
                    }
                )
                .build()
            
            val imageLoader = ImageLoader.Builder(ivCocktail.context)
                .crossfade(true)
                .build()
            
            imageLoader.enqueue(request)
            
            tvName.text = "Cocktail name: $cocktailName"
            tvId.text = "Cocktail id: $id"
            tvCategory.text = "Cocktail category: $category"
            tvCocktailType.text = "Cocktail type: $cocktailType"
            tvGlassType.text = "Glass type: $glassType"
        }
    }
}