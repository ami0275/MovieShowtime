package com.amit.bms.firstscreen_presentation.ui.fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.amit.bms.common_utils.Constants.DATE_FORMAT
import com.amit.bms.firstscreen_presentation.R
import com.amit.bms.firstscreen_presentation.adapters.ShowDateAdapter
import com.amit.bms.firstscreen_presentation.adapters.ShowListMainAdapter
import com.amit.bms.firstscreen_presentation.base.BaseFragment
import com.amit.bms.firstscreen_presentation.databinding.HomeFragmentBinding
import com.amit.bms.firstscreen_presentation.model.CalendarDateModel
import com.amit.bms.firstscreen_presentation.models.ShowTimeResponse
import com.amit.bms.firstscreen_presentation.models.ShowtimeDTO
import com.amit.bms.firstscreen_presentation.utils.HorizontalItemDecoration
import com.amit.bms.firstscreen_presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private var showTimeData: ShowTimeResponse?=null
    private val sdf = SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH)
    private val cal = Calendar.getInstance(Locale.ENGLISH)
    private val currentDate = Calendar.getInstance(Locale.ENGLISH)
    private val dates = ArrayList<Date>()
    private lateinit var adapter: ShowDateAdapter
    private val calendarList2 = ArrayList<CalendarDateModel>()

    private val navController by lazy {
        findNavController(requireActivity(), R.id.home_nav_graph)
    }

    private val _castListAdapter by lazy {
        ShowListMainAdapter(
            emptyList(),
            ::onItemClick
        )
    }

    private var mainAdapter: ShowListMainAdapter? = null
        get() {
            kotlin.runCatching {
                field = _castListAdapter
            }.onFailure {
                Timber.e(it)
            }
            return field
        }

    private val homeViewModel: MainViewModel by viewModels()

    override fun initializeViews() {
        binding.progressBar.visibility = View.VISIBLE
        setUpAdapter()
        setUpCalendar()
        setUpClickListener()
    }

    override fun initializeObservers() {
        homeViewModel.showTimeLiveData.observe(this) { showTimeData ->
            binding.progressBar.visibility = View.GONE
            mainAdapter?.updateList(showTimeData.venues)
            this.showTimeData=showTimeData
            Timber.d("showTimeData: ${showTimeData.venues}")
        }

        homeViewModel.venueDTO.observe(this) { venueData ->
            mainAdapter?.updateList(venueData)
        }
    }

    /**
     * Setting up adapter for recyclerview
     */
    private fun setUpAdapter() {
        binding.showTimeRv.adapter = mainAdapter
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.single_calendar_margin)
        binding.clCalender.recyclerView.addItemDecoration(HorizontalItemDecoration(spacingInPixels))
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.clCalender.recyclerView)
        adapter = ShowDateAdapter (::onCalenderItemClick)
        binding.clCalender.recyclerView.adapter = adapter
    }


    private fun onItemClick(data: ShowtimeDTO, position: Int) {
        navController.navigateUp()
        navController.navigate(R.id.proceedTicketBookFragment)
    }

    private fun onCalenderItemClick(data: CalendarDateModel, position: Int) {
        resetCalenderAdapter(data,position)
        homeViewModel.filterShowTime(data.calendarDate)
    }

    private fun resetCalenderAdapter(data: CalendarDateModel, position: Int) {
        calendarList2.forEachIndexed { index, calendarModel ->
            calendarModel.isSelected = index == position
        }
        adapter.setData(calendarList2)
    }

    /**
     * Function to setup calendar for every month
     */
    private fun setUpCalendar() {
        //Todo: This logic should be in ViewModel
        val calendarList = ArrayList<CalendarDateModel>()
        binding.clCalender.tvDateMonth.text = sdf.format(cal.time)
        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        dates.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (dates.size < maxDaysInMonth) {
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        calendarList2.clear()
        calendarList2.addAll(calendarList)
        adapter.setData(calendarList)
    }


    /**
     * Set up click listener
     */
    private fun setUpClickListener() {
        binding.clCalender.ivCalendarNext.setOnClickListener {
            cal.add(Calendar.MONTH, 1)
            setUpCalendar()
        }
        binding.clCalender.ivCalendarPrevious.setOnClickListener {
            cal.add(Calendar.MONTH, -1)
            if (cal == currentDate)
                setUpCalendar()
            else
                setUpCalendar()
        }
        binding.ivSearch.setOnClickListener { v: View ->
            showSnackBar("Select for Movies")
        }
        binding.ivFilter.setOnClickListener { v: View ->
            showSnackBar("Select filters")
        }
        binding.tvBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }


}