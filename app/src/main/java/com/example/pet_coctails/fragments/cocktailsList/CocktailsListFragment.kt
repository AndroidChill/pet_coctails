package com.example.pet_coctails.fragments.cocktailsList

import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_coctails.R
import com.example.pet_coctails.core.abstraction.BaseFragment
import com.example.pet_coctails.databinding.FragmentCocktailsListBinding
import com.example.pet_coctails.features.auth.BaseApplication
import com.example.pet_coctails.features.auth.di.DaggerAuthComponent
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState.Action
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState.Event.MoveToCocktailInfo
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsViewModel
import kotlinx.coroutines.launch


class CocktailsListFragment : BaseFragment<FragmentCocktailsListBinding, CocktailsViewModel>() {


    override val getViewBinding: (LayoutInflater) -> FragmentCocktailsListBinding
        get() = FragmentCocktailsListBinding::inflate
    
    override val getViewModelClass: Class<CocktailsViewModel>
        get() = CocktailsViewModel::class.java
    
    override fun setupDaggerComponent() {
        val authComponent = DaggerAuthComponent.builder()
            .coreComponent((requireActivity().application as BaseApplication).getCoreComponent())
            .build()
        
        authComponent.inject(this)
    }
    
    private lateinit var adapter: CocktailsListAdapter
    
    override fun initUI() {

        adapter = CocktailsListAdapter {
            viewModel.handleAction(Action.OnClickCocktail(it))
        }
        
        binding.rvCocktails.layoutManager =
            LinearLayoutManager(requireContext())
        
        binding.rvCocktails.adapter = adapter

        lifecycleScope.launch {

            viewModel.state.collect {
                it.events.forEach { event ->
                    when (event) {
                        is CocktailsState.Event.LoadAllCocktails -> {
                            adapter.addData(event.data.map {
                                CocktailsListData(
                                    imageLink = it.strDrinkThumb,
                                    cocktailName = it.strDrink,
                                    id = it.idDrink,
                                    category = it.strCategory,
                                    cocktailType = it.strAlcoholic,
                                    glassType = it.strGlass
                                )
                            })
                        }
                        is MoveToCocktailInfo -> {
                            findNavController().navigate(R.id.action_cocktailsListFragment_to_cocktailInfoFragment, Bundle().apply {
                                putString("id", event.idDrink)
                            })
                        }
                    }
                }
            }
        }
    }

}