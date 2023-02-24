package com.amit.bms.secondscreen_presentation.fragment

import android.os.Bundle
import com.amit.bms.common_utils.Activities
import com.amit.bms.common_utils.Constants
import com.amit.bms.common_utils.Navigator
import com.amit.bms.secondscreen_presentation.base.BaseFragment
import com.amit.bms.secondscreen_presentation.databinding.FragmentBookTicketsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class TicketDetailsFragment :
    BaseFragment<FragmentBookTicketsBinding>(FragmentBookTicketsBinding::inflate) {
    @Inject
    lateinit var provider: Navigator.Provider

    override fun initializeViews() {
        binding.btnBookTicket.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Constants.ARGS_MOVIE_NAME, "Avatar")
            provider.getActivities(Activities.ShowTimeActivity).navigate(requireActivity(), bundle)
            requireActivity().finish()
        }
    }


    override fun initializeObservers() {

    }


}