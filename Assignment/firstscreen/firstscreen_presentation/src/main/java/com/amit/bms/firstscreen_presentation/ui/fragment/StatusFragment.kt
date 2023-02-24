package com.amit.bms.firstscreen_presentation.ui.fragment

import androidx.navigation.Navigation
import com.amit.bms.firstscreen_presentation.R
import com.amit.bms.firstscreen_presentation.base.BaseFragment
import com.amit.bms.firstscreen_presentation.databinding.FragmentStatusBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StatusFragment :
    BaseFragment<FragmentStatusBinding>(FragmentStatusBinding::inflate) {

    private val navController by lazy {
        Navigation.findNavController(requireActivity(), R.id.home_nav_graph)
    }

    override fun initializeViews() {
        binding.btnOk.setOnClickListener {
            showSnackBar("Book another show ticket")
        }
    }

    override fun initializeObservers() {

    }

}