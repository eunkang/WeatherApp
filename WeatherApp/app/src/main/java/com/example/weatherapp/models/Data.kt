package com.example.weatherapp.models


import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Data(
    val cloudCover: Double,
    val humidity: Double,
    val icon: String,
    val summary: String,
    val sunriseTime: Int,
    val sunsetTime: Int,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val time: Int
) : Parcelable //for passing data to another activity/fragment