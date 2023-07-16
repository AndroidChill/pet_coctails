package com.example.pet_coctails.fragments.coctailsList

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.pet_coctails.R
import com.example.pet_coctails.activity.main.MainViewModel
import com.example.pet_coctails.core.abstraction.BaseFragment
import com.example.pet_coctails.databinding.ActivityMainBinding
import com.example.pet_coctails.databinding.FragmentCocktailsListBinding
import com.example.pet_coctails.features.auth.BaseApplication
import com.example.pet_coctails.features.auth.di.DaggerAuthComponent
import com.example.pet_coctails.fragments.MainFragment
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsState
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsState.Action
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsState.Event.MoveToCocktailINfo
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsViewModel
import kotlinx.coroutines.launch

// TODO Происходит что-то странное в старых функциях

class CocktailsListFragment : BaseFragment<FragmentCocktailsListBinding, CocktailsViewModel>(){

//    private lateinit var binding: FragmentCocktailsListBinding
    
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
    
    private lateinit var adapter: CocktailsAdapter
    
    override fun initUI() {
        // TODO ("дополнительно посмотреть разницук parentFragmentManger childFragmentManager")
//        childFragmentManager.beginTransaction()
//            .replace(R.id.container, MainFragment())
//            .commit()

//        cocktailsAdapter.addData(
//
//        )
        
        adapter = CocktailsAdapter {
            viewModel.handleAction(Action.OnClickCocktail(it))
        }
        
        binding.rvCocktails.layoutManager =
            LinearLayoutManager(requireContext()) // todo а что не так?(
        
        binding.rvCocktails.adapter = adapter
        
        lifecycleScope.launch {
            viewModel.state.collect {
                it.events.forEach { event ->
                    when (event) {
                        is CocktailsState.Event.LoadAllCocktails -> {
                            adapter.addData(event.data.map {
                                CocktailsData(
                                    imageLink = "",
                                    cocktailName = it.strDrink,
                                    id = it.idDrink,
                                    category = it.strCategory,
                                    cocktailType = it.strAlcoholic,
                                    glassType = it.strGlass
                                )
                            })
                        }
                        is MoveToCocktailINfo -> {
                            findNavController().navigate(R.id.action_cocktailsListFragment_to_cocktailInfoFragment, Bundle().apply {
                                putString("id", event.data.idDrink)
                            })
                        }
                    }
                }
            }
        }
    }
    
}