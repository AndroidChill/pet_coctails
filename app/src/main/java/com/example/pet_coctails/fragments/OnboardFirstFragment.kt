package com.example.pet_coctails.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pet_coctails.R
import com.example.pet_coctails.databinding.FragmentOnboardFirstBinding

class OnboardFirstFragment : Fragment() {

    private lateinit var binding: FragmentOnboardFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOnboardFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onboardFirstFragment_to_onboardSecondFragment)
        }

    }
}