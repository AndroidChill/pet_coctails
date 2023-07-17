package com.example.pet_coctails.fragments.cocktailInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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

        arguments?.apply {
            id = getString("id", "")
        }

        lifecycleScope.launch {

            viewModel.state.collect {
                it.events.forEach { event ->

                    when (event) {

                        is CocktailInfoState.Event.LoadFullCocktailInfo -> {
                            adapter.addData(event.data.map {
                                CocktailInfoData(
                                    imageLink = "",
                                    cocktailName = it.strDrink,
                                    id = it.idDrink,
                                    category = it.strCategory,
                                    cocktailType = it.strAlcoholic,
                                    glassType = it.strGlass,
                                    instructions = it.strInstructions,
                                    ingredient1 = it.strIngredient1,
                                    ingredient2 = it.strIngredient2,
                                    ingredient3 = it.strIngredient3,
                                    ingredient4 = it.strIngredient4,
                                    ingredient5 = it.strIngredient5,
                                    ingredient6 = it.strIngredient6,
                                    ingredient7 = it.strIngredient7,
                                    ingredient8 = it.strIngredient8,
                                    ingredient9 = it.strIngredient9,
                                    ingredient10 = it.strIngredient10,
                                    ingredient11 = it.strIngredient11,
                                    ingredient12 = it.strIngredient12,
                                    ingredient13 = it.strIngredient13,
                                    ingredient14 = it.strIngredient14,
                                    ingredient15 = it.strIngredient15,
                                    measureIngredient1 = it.strMeasure1,
                                    measureIngredient2 = it.strMeasure2,
                                    measureIngredient3 = it.strMeasure3,
                                    measureIngredient4 = it.strMeasure4,
                                    measureIngredient5 = it.strMeasure5,
                                    measureIngredient6 = it.strMeasure6,
                                    measureIngredient7 = it.strMeasure7,
                                    measureIngredient8 = it.strMeasure8,
                                    measureIngredient9 = it.strMeasure9,
                                    measureIngredient10 = it.strMeasure10,
                                    measureIngredient11 = it.strMeasure11,
                                    measureIngredient12 = it.strMeasure12,
                                    measureIngredient13 = it.strMeasure13,
                                    measureIngredient14 = it.strMeasure14,
                                    measureIngredient15 = it.strMeasure15
                                )
                            })
                        }
                    }
                }
            }
        }

    }

}