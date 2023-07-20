package com.example.pet_coctails.fragments.randomCocktail

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.pet_coctails.R
import com.example.pet_coctails.core.abstraction.BaseFragment
import com.example.pet_coctails.databinding.FragmentCocktailRandomBinding
import com.example.pet_coctails.features.auth.BaseApplication
import com.example.pet_coctails.features.auth.di.DaggerAuthComponent
import com.example.pet_coctails.fragments.cocktailInfo.bottomFragment.BottomFragment
import kotlinx.coroutines.launch

class CocktailRandomFragment : BaseFragment<FragmentCocktailRandomBinding, CocktailRandomViewModel>() {


    override val getViewBinding: (LayoutInflater) -> FragmentCocktailRandomBinding
        get() = FragmentCocktailRandomBinding::inflate

    override val getViewModelClass: Class<CocktailRandomViewModel>
        get() = CocktailRandomViewModel::class.java

    override fun setupDaggerComponent() {
        val authComponent = DaggerAuthComponent.builder()
            .coreComponent((requireActivity().application as BaseApplication).getCoreComponent())
            .build()

        authComponent.inject(this)
    }

    private lateinit var adapter: CocktailRandomAdapter

    override fun initUI() {

        adapter = CocktailRandomAdapter()

        binding.rvIngredientsList.layoutManager =
            LinearLayoutManager(requireContext())

        binding.rvIngredientsList.adapter = adapter



        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_cocktailRandomFragment_to_cocktailsListFragment)
        }

        lifecycleScope.launch {
            viewModel.getRandomCocktailInfo()
        }

        lifecycleScope.launch {

            viewModel.state.collect {
                it.events.forEach { event ->

                    when (event) {

                        is CocktailRandomState.Event.LoadFullCocktailInfo -> {
                            adapter.addData(event.data.some)
                            binding.iv.load(event.data.imageLink)
                            binding.tvName.text = event.data.name
                            binding.tvId.text = "Cocktail ID: $id"
                            binding.tvCategory.text = "Cocktail category: " + event.data.category
                            binding.tvCocktailType.text = "Cocktail type: " + event.data.cocktailType
                            binding.tvGlassType.text = "Glass type: " + event.data.glass
                            binding.tvInstructionText.text = event.data.instruction

                        }

                        is CocktailRandomState.Event.ShowError -> {
                            binding.iv.setImageResource(R.drawable.ups_retry)
                        }

                    }
                }
            }
        }

        binding.btnIngredients.setOnClickListener {
            val dialogFragment = BottomFragment()
            dialogFragment.show(parentFragmentManager, "ingredients")
        }

        binding.btnRandom.setOnClickListener {
            findNavController().navigate(R.id.action_cocktailRandomFragment_self)
        }

    }
    }
