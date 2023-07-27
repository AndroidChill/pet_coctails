package com.example.pet_coctails.fragments.cocktailsList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_coctails.R
import com.example.pet_coctails.RomApplication
import com.example.pet_coctails.core.abstraction.BaseFragment
import com.example.pet_coctails.dataBase.CocktailsDataEntity
import com.example.pet_coctails.databinding.FragmentCocktailsListBinding
import com.example.pet_coctails.features.auth.BaseApplication
import com.example.pet_coctails.features.auth.di.DaggerAuthComponent
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState.Action
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsState.Event.MoveToCocktailInfo
import com.example.pet_coctails.fragments.cocktailsList.api.CocktailsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
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

//        lifecycleScope.launch(Dispatchers.IO) {
//            val idCocktails = ((requireActivity()).application as? RomApplication)?.getDataBase()
//                ?.getStatisticDao()?.getCocktailData()
//            val test = idCocktails
//        }
        
        val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.i("database", "error already exist")
        }
        
        adapter =
            CocktailsListAdapter(onClick = { viewModel.handleAction(Action.OnClickCocktail(it)) },
                onClickFavourite = { id, isSelect ->
                    lifecycleScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
                        
                        if (isSelect) {
                            val idCocktails =
                                ((requireActivity()).application as? RomApplication)?.getDataBase()
                                    ?.getCocktailsDao()?.deleteCocktailDataById(
                                        id.toLong()
                                    )
                            val k = idCocktails
                        } else {
                            val idCocktails =
                                ((requireActivity()).application as? RomApplication)?.getDataBase()
                                    ?.getCocktailsDao()?.insertNewCocktailData(
                                        CocktailsDataEntity(id)
                                    )
                            val test = idCocktails
                        }
                        
                    }
                })
        
        binding.rvCocktails.layoutManager = LinearLayoutManager(requireContext())
        
        binding.rvCocktails.adapter = adapter
        
        binding.btnRandom.setOnClickListener {
            findNavController().navigate(R.id.action_cocktailsListFragment_to_cocktailRandomFragment)
        }
        
        lifecycleScope.launch {
            
            viewModel.state.collect {
                it.events.forEach { event ->
                    when (event) {
                        is CocktailsState.Event.LoadAllCocktails -> {
                            val data = event.data.map {
                                CocktailsListData(
                                    imageLink = it.strDrinkThumb,
                                    cocktailName = it.strDrink,
                                    id = it.idDrink,
                                    category = it.strCategory,
                                    cocktailType = it.strAlcoholic,
                                    glassType = it.strGlass,
                                    isHeart = false
                                )
                            }

                            lifecycleScope.launch(Dispatchers.IO) {
                                val idCocktails =
                                    ((requireActivity()).application as? RomApplication)?.getDataBase()
                                        ?.getCocktailsDao()?.getCocktailData()
                                        ?.map { it.idCocktail } ?: emptyList()
                                data.forEach { item ->
                                    item.isHeart = idCocktails.contains(item.id)
                                }
                            }
                            
                            adapter.addData(data)
                        }
                        
                        is MoveToCocktailInfo -> {
                            findNavController().navigate(R.id.action_cocktailsListFragment_to_cocktailInfoFragment,
                                Bundle().apply {
                                    putString("id", event.idDrink)
                                })
                        }
                        
                        is CocktailsState.Event.ShowError -> {
                            Toast.makeText(context, "Ups, internet is missing", LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
        
    }
    
}