package com.example.pet_coctails.fragments.cocktailInfo.bottomFragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_coctails.databinding.BottomSheetDialogBinding
import com.example.pet_coctails.fragments.CocktailClear
import com.example.pet_coctails.fragments.cocktailInfo.CocktailInfoAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.Serializable

class BottomFragment(): BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDialogBinding

//    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = BottomSheetDialogBinding.inflate(inflater, container, false)
        // фон для диалога
//        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
//
//        bottomSheetBehavior = BottomSheetBehavior.from(binding.contentDialog)
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        
        return binding.root
    }

    // todo не понятно как передать данные?
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CocktailInfoAdapter()

            binding.rvDialogIngredientsList.layoutManager =
                LinearLayoutManager(requireContext())

            binding.rvDialogIngredientsList.adapter = adapter
        
        val data = (arguments?.getSerializable("data") as? Array<CocktailClear>)?.toList()
        Log.i("test_data", data.toString())
        data?.let {
            adapter.addData(it)
        }
        

    }
    
    override fun onDetach() {
        setFragmentResult("option", Bundle().apply {
            putBoolean("is_destroy", true)
        })
        super.onDetach()
    }
    
    override fun onDestroyView() {
        
        super.onDestroyView()
    }
    
    companion object {
        fun newInstance(data: List<CocktailClear>) = BottomFragment().apply {
            arguments = Bundle().apply {
                putSerializable("data", data.toTypedArray())
            }
        }
    }


}