package com.example.pet_coctails.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pet_coctails.R
import com.example.pet_coctails.databinding.FragmentCocktailsListBinding

class CocktailsListFragment : Fragment() {

    private lateinit var binding: FragmentCocktailsListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cocktails_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}