package com.example.weatherapp.dagger

import com.example.weatherapp.viewModel.WeatherViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [ApiModule::class])
interface ApiComponent {
    fun inject(target: WeatherViewModel)
}