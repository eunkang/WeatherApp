package com.example.weatherapp.network

import com.example.weatherapp.models.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET

private const val API_KEY = "744583b6ca27ea957c53928ce7b90db5/"
private const val ATL_LAT = "33.7490"
private const val ATL_LON = "-84.3880"

// interface defines how Retrofit talks to the web server using HTTP request
interface WeatherApiService {
    @GET(API_KEY + ATL_LAT + "," + ATL_LON)
    fun getWeather(): Observable<WeatherResponse>

}


