package com.example.weatherapp.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataX(
    val icon: String,
    val temperature: Double,
    val time: Int
)