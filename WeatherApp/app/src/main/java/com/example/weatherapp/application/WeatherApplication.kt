package com.example.weatherapp.application

import android.app.Application
import com.example.weatherapp.dagger.ApiComponent
import com.example.weatherapp.dagger.DaggerApiComponent

class WeatherApplication: Application() {

    companion object {
        lateinit var instance: WeatherApplication
    }

    init {
        instance = this
    }

    lateinit var component: ApiComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApiComponent.builder().build()
    }
}