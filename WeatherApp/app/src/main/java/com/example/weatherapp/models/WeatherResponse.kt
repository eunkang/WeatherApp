package com.example.weatherapp.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse (
    val currently: Currently,
    val daily: Daily,
    val hourly: Hourly
)