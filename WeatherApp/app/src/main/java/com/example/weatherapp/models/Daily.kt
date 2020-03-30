package com.example.weatherapp.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Daily(
    val `data`: List<Data>
)