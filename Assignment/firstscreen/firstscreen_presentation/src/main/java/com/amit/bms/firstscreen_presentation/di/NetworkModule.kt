package com.amit.bms.firstscreen_presentation.di

import com.amit.bms.firstscreen_presentation.api.ShowTimesAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesShowTimesAPI(retrofit: Retrofit) : ShowTimesAPI {
        return retrofit.create(ShowTimesAPI::class.java)
    }
}