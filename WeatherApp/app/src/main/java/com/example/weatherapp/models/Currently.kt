package com.example.weatherapp.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Currently(
    val icon: String,
    val summary: String,
    val temperature: Double,
    val time: Int
)