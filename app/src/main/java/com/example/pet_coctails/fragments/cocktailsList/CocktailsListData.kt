package com.example.pet_coctails.fragments.cocktailsList

data class CocktailsListData(
    val imageLink: String,
    val cocktailName: String,
    val id: String,
    val category: String,
    val cocktailType: String,
    val glassType: String,
    var isHeart: Boolean
)