package com.amit.bms.firstscreen_presentation.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amit.bms.common_utils.Constants
import com.amit.bms.firstscreen_presentation.model.CalendarDateModel
import com.amit.bms.firstscreen_presentation.models.ShowTimeResponse
import com.amit.bms.firstscreen_presentation.models.VenueDTO
import com.amit.bms.firstscreen_presentation.repository.ShowTimeRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val showTimeRepositoryImpl: ShowTimeRepositoryImpl) :
    ViewModel() {

    val showTimeLiveData: LiveData<ShowTimeResponse>
        get() = showTimeRepositoryImpl.showTimesData

    /*   private var _calendarList: MutableLiveData<List<CalendarDateModel>> = MutableLiveData()
       val calendarList: LiveData<List<CalendarDateModel>> = _calendarList*/


    private var _venueDTO: MutableLiveData<List<VenueDTO>> = MutableLiveData()
    val venueDTO: LiveData<List<VenueDTO>> = _venueDTO

    init {
        viewModelScope.launch {
            showTimeRepositoryImpl.getShowTimeResponse()
        }
    }


    @SuppressLint("SimpleDateFormat")
    fun dateFormatter(showDateCode: String): Date {
        val format = SimpleDateFormat(Constants.DATE_FORMAT)
        return format.parse(showDateCode)
    }


    fun filterShowTime(calendarDate: String) {
        // TODO: We can filter the list based on actual use-case
        showTimeLiveData.value?.let { sData ->
            sData.venues.filterNot {
                it.showDate.contains(calendarDate)
            }.toList()
                .also {
                    if (it.isNotEmpty()) {
                        _venueDTO.value = it
                    }
                }
        }
    }

}