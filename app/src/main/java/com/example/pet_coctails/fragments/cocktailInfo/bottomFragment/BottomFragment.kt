package com.example.pet_coctails.fragments.cocktailInfo.bottomFragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_coctails.R
import com.example.pet_coctails.databinding.FragmentBottomSheetBinding
import com.example.pet_coctails.fragments.cocktailInfo.CocktailInfoAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomFragment: BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        // фон для диалога
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        return binding.root
    }

    // todo не понятно как передать данные?
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CocktailInfoAdapter()

            binding.rvIngredientsList.layoutManager =
                LinearLayoutManager(requireContext())

            binding.rvIngredientsList.adapter = adapter



    }

    override fun onDestroyView() {
        super.onDestroyView()
        setFragmentResult("option", bundleOf("action" to "icon_show"))
    }


}