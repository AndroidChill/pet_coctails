package com.example.pet_coctails.fragments.coctailsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_coctails.R
import com.example.pet_coctails.databinding.FragmentCocktailsListBinding

class CocktailsListFragment : Fragment(), CocktailsAdapter.Listener {

    private lateinit var binding: FragmentCocktailsListBinding

    private val cocktailsAdapter = CocktailsAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCocktailsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val data = listOf(
        CocktailsData(
            imageLink = R.mipmap.ic_launcher_round,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small",
            info = "Open cocktail info"
        ),
        CocktailsData(
            imageLink = R.mipmap.ic_launcher_round,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small",
            info = "Open cocktail info"
        ),
        CocktailsData(
            imageLink = R.mipmap.ic_launcher_round,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small",
            info = "Open cocktail info"
        ),
        CocktailsData(
            imageLink = R.mipmap.ic_launcher_round,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small",
            info = "Open cocktail info"
        ),
        CocktailsData(
            imageLink = R.mipmap.ic_launcher_round,
            cocktailName = "Samba",
            id = 345867,
            category = "short drink",
            cocktailType = "light",
            glassType = "small",
            info = "Open cocktail info"
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

    override fun onClick (cocktails: CocktailsViewHolder) {
        findNavController().navigate(R.id.action_cocktailsListFragment_to_cocktailInfoFragment)
    }
}