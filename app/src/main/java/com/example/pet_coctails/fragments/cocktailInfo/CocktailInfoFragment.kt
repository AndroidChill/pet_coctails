package com.example.pet_coctails.fragments.cocktailInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.pet_coctails.R
import com.example.pet_coctails.core.abstraction.BaseFragment
import com.example.pet_coctails.databinding.FragmentCocktailInfoBinding
import com.example.pet_coctails.features.auth.BaseApplication
import com.example.pet_coctails.features.auth.data.CocktailFullInfo
import com.example.pet_coctails.features.auth.di.DaggerAuthComponent
import com.example.pet_coctails.fragments.cocktailsList.CocktailsListData
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsViewModel
import kotlinx.coroutines.launch

class CocktailInfoFragment : BaseFragment<FragmentCocktailInfoBinding, CocktailInfoViewModel>() {


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

        adapter = CocktailInfoAdapter()
        
        binding.rvIngredientsList.layoutManager =
            LinearLayoutManager(requireContext())

        binding.rvIngredientsList.adapter = adapter



        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_cocktailInfoFragment_to_cocktailsListFragment)
        }

        arguments?.apply {
            id = getString("id", "")
        }
        
        lifecycleScope.launch {
            viewModel.getFullCocktailInfo(id ?: "")
        }

        lifecycleScope.launch {

            viewModel.state.collect {
                it.events.forEach { event ->

                    when (event) {

                        is CocktailInfoState.Event.LoadFullCocktailInfo -> {
                            adapter.addData(event.data.some)
                            binding.iv.load(event.data.imageLink)
                            binding.tvName.text = event.data.name
                            binding.tvId.text = "Cocktail ID: $id"
                            binding.tvCategory.text = "Cocktail category: " + event.data.category
                            binding.tvCocktailType.text = "Cocktail type: " + event.data.cocktailType
                            binding.tvGlassType.text = "Glass type: " + event.data.glass
                            binding.tvInstructionText.text = event.data.instruction

                        }
                    }
                }
            }
        }

    }

}