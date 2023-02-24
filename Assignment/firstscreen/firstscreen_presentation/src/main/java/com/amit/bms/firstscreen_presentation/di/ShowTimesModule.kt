package com.amit.bms.firstscreen_presentation.di
import com.amit.bms.firstscreen_presentation.api.ShowTimesAPI
import com.amit.bms.firstscreen_presentation.repository.ShowTimeRepositoryImpl
import com.amit.bms.firstscreen_presentation.repository.ShowTimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class  ShowTimesModule {
    @Provides
    fun provideShowTimesRepo(showTimesAPI: ShowTimesAPI): ShowTimeRepository {
        return ShowTimeRepositoryImpl(showTimesAPI)
    }

}