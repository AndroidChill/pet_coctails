package com.example.pet_coctails.features.auth.domain.model.cocktailList


data class CocktailsListRequest(
    val imageLink: Int,
    val cocktailName: String,
    val id: Int,
    val category: String,
    val cocktailType: String,
    val glassType: String
)