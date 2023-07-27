package com.example.pet_coctails.fragments.cocktailInfo

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.pet_coctails.R
import com.example.pet_coctails.core.abstraction.BaseFragment
import com.example.pet_coctails.databinding.FragmentCocktailInfoBinding
import com.example.pet_coctails.features.auth.BaseApplication
import com.example.pet_coctails.features.auth.di.DaggerAuthComponent
import com.example.pet_coctails.fragments.cocktailInfo.CocktailInfoState.Event.ShowError
import com.example.pet_coctails.fragments.cocktailInfo.bottomFragment.BottomFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.launch

class CocktailInfoFragment : BaseFragment<FragmentCocktailInfoBinding, CocktailInfoViewModel>() {

    var currentFloatY = 0f

    override val getViewBinding: (LayoutInflater) -> FragmentCocktailInfoBinding
        get() = FragmentCocktailInfoBinding::inflate

    override val getViewModelClass: Class<CocktailInfoViewModel>
        get() = CocktailInfoViewModel::class.java
    
//    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    
    private var isShowBottomSheet = false

    override fun setupDaggerComponent() {
        val authComponent = DaggerAuthComponent.builder()
            .coreComponent((requireActivity().application as BaseApplication).getCoreComponent())
            .build()

        authComponent.inject(this)
    }

    private lateinit var adapter: CocktailInfoAdapter

    private var id: String? = ""

    @SuppressLint("ClickableViewAccessibility")
    override fun initUI() {
        
        binding.content.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    currentFloatY = motionEvent.y
                }
                MotionEvent.ACTION_MOVE -> {
                    if (motionEvent.y < currentFloatY && !isShowBottomSheet) {
                        isShowBottomSheet = true
                        showBottomSheetDialog()
                        Log.i("scroll_test", "down")
                    }
                }
                else -> {}
            }
            return@setOnTouchListener true
        }
        
        


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
                            binding.tvCocktailType.text =
                                "Cocktail type: " + event.data.cocktailType
                            binding.tvGlassType.text = "Glass type: " + event.data.glass
                            binding.tvInstructionText.text = event.data.instruction

                        }

                        is ShowError -> {
                            binding.iv.setImageResource(R.drawable.ups_retry)
                        }

                    }
                }
            }
        }

    }
    
    override fun onResume() {
        super.onResume()
        setFragmentResultListener("option") { data, bundle ->
            if (bundle.getBoolean("is_destroy", false)) {
                isShowBottomSheet = false
            }
        }
    }

    private fun showBottomSheetDialog() {

        val dialog = BottomFragment.newInstance(viewModel.state.value.cocktail.some)

        dialog.show(parentFragmentManager, dialog.tag)
    }
}