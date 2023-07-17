package com.example.pet_coctails.fragments.overs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pet_coctails.activity.main.MainActivity
import com.example.pet_coctails.databinding.FragmentOnboardSecondBinding

class OnboardSecondFragment : Fragment() {

    private lateinit var binding: FragmentOnboardSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOnboardSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            requireActivity().startActivity(intent)
            requireActivity().finish()
        }

    }
}