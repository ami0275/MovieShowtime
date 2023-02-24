package com.amit.bms.firstscreen_presentation.api


import com.amit.bms.firstscreen_presentation.models.ShowTimeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ShowTimesAPI {

    @GET("/movie_showtimes")
    suspend fun getShowTimes(): Response<ShowTimeResponse>
}