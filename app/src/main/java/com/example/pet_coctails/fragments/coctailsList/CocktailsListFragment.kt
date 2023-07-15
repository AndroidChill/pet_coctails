package com.example.pet_coctails.fragments.coctailsList

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
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
import com.example.pet_coctails.fragments.coctailsList.api.CocktailsViewModel

// TODO Как viewModel вызывать? Наследоваться не хочет

class CocktailsListFragment : BaseFragment<FragmentCocktailsListBinding, CocktailsViewModel>(), CocktailsAdapter.Listener {

//    private lateinit var binding: FragmentCocktailsListBinding

    override val getViewBinding: (LayoutInflater) -> FragmentCocktailsListBinding
        get() = FragmentCocktailsListBinding::inflate

    override val getViewModelClass: Class <CocktailsViewModel>
        get() = CocktailsViewModel::class.java


    override fun setupDaggerComponent() {
        val authComponent = DaggerAuthComponent
            .builder()
            .coreComponent((application as BaseApplication).getCoreComponent())
            .build()

        authComponent.inject(this)
    }

    private val cocktailsAdapter = CocktailsAdapter(this)

    override fun initUI() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()

//        cocktailsAdapter.addData(
//
//        )

        binding.rvCocktails.layoutManager = LinearLayoutManager(requireContext()) // todo а что не так?(

        binding.rvCocktails.adapter = cocktailsAdapter

    }

    override fun onClick (cocktails: CocktailsViewHolder) {

        this@CocktailsListFragment.findNavController().navigate(R.id.action_cocktailsListFragment_to_cocktailInfoFragment)
    }
}