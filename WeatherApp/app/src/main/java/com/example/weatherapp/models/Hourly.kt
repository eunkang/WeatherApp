package com.example.weatherapp.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hourly(
    val `data`: List<DataX>
)