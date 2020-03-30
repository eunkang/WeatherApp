package com.example.weatherapp.dagger

import com.example.weatherapp.network.WeatherApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun apiProvider(): WeatherApiClient = WeatherApiClient()
}