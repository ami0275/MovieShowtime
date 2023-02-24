package com.amit.bms.firstscreen_presentation.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amit.bms.firstscreen_presentation.api.ShowTimesAPI
import com.amit.bms.firstscreen_presentation.models.ShowTimeResponse
import javax.inject.Inject


class ShowTimeRepositoryImpl @Inject constructor(private val showTimeAPI: ShowTimesAPI) :
    ShowTimeRepository {

    private val _showTimesData = MutableLiveData<ShowTimeResponse>()
    val showTimesData: LiveData<ShowTimeResponse>
        get() = _showTimesData

    override suspend fun getShowTimeResponse() {
        val result = showTimeAPI.getShowTimes()
        if (result.isSuccessful) {
            result.body()?.let {
                _showTimesData.postValue(it)
            }
        }
    }

}