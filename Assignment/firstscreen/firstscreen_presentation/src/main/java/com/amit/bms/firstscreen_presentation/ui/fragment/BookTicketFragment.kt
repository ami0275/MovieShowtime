package com.amit.bms.firstscreen_presentation.ui.fragment

import androidx.navigation.Navigation
import com.amit.bms.firstscreen_presentation.R
import com.amit.bms.firstscreen_presentation.base.BaseFragment
import com.amit.bms.firstscreen_presentation.databinding.FragmentShowItemsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BookTicketFragment :
    BaseFragment<FragmentShowItemsBinding>(FragmentShowItemsBinding::inflate) {

    private val navController by lazy {
        Navigation.findNavController(requireActivity(), R.id.home_nav_graph)
    }

    override fun initializeViews() {
        binding.btnBookTicket.setOnClickListener {
            navController.navigateUp()
            navController.navigate(R.id.statusFragment)
        }
    }

    override fun initializeObservers() {

    }

}