package com.example.pet_coctails.fragments.coctailsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_coctails.R
import com.example.pet_coctails.databinding.FragmentCocktailsListBinding

class CocktailsListFragment : Fragment() {

    private lateinit var binding: FragmentCocktailsListBinding

    private val cocktailsAdapter = CocktailsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCocktailsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val data = listOf(
        CocktailsData(
            imageLink = R.drawable.ic_launcher_foreground,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small"
        ),
        CocktailsData(
            imageLink = R.drawable.ic_launcher_foreground,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small"
        ),
        CocktailsData(
            imageLink = R.drawable.ic_launcher_foreground,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small"
        ),
        CocktailsData(
            imageLink = R.drawable.ic_launcher_foreground,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small"
        ),
        CocktailsData(
            imageLink = R.drawable.ic_launcher_foreground,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small"
        ),
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cocktailsAdapter.addData(
            data
        )

        binding.rvCocktails.layoutManager = LinearLayoutManager(requireContext())

        binding.rvCocktails.adapter = cocktailsAdapter
    }
}