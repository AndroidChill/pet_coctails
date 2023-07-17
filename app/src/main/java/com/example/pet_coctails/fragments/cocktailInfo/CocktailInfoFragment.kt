package com.example.pet_coctails.fragments.cocktailInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_coctails.R
import com.example.pet_coctails.core.abstraction.BaseFragment
import com.example.pet_coctails.databinding.FragmentCocktailInfoBinding
import com.example.pet_coctails.features.auth.BaseApplication
import com.example.pet_coctails.features.auth.di.DaggerAuthComponent
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsViewModel

class CocktailInfoFragment : BaseFragment<FragmentCocktailInfoBinding, CocktailInfoViewModel>() {

//    private lateinit var binding: FragmentCocktailInfoBinding
    // todo соединить с ViewModel

    override val getViewBinding: (LayoutInflater) -> FragmentCocktailInfoBinding
        get() = FragmentCocktailInfoBinding::inflate

    override val getViewModelClass: Class<CocktailInfoViewModel>
        get() = CocktailInfoViewModel::class.java

    override fun setupDaggerComponent() {
        val authComponent = DaggerAuthComponent.builder()
            .coreComponent((requireActivity().application as BaseApplication).getCoreComponent())
            .build()

        authComponent.inject(this)
    }

    private lateinit var adapter: CocktailInfoAdapter

    private var id: String? = ""

    override fun initUI() {
        binding.rvIngredientsList.layoutManager =
            LinearLayoutManager(requireContext())

        binding.rvIngredientsList.adapter = adapter

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_cocktailInfoFragment_to_cocktailsListFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_cocktailInfoFragment_to_cocktailsListFragment)
        }
        
        arguments?.apply {
            id = getString("id", "")
        }

    }
    
}