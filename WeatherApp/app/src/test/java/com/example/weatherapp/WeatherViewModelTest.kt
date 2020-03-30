package com.example.weatherapp

import com.example.weatherapp.models.Hourly
import com.example.weatherapp.models.Daily
import com.example.weatherapp.models.Currently
import com.example.weatherapp.models.WeatherResponse
import com.example.weatherapp.models.DataX
import com.example.weatherapp.models.Data
import com.example.weatherapp.viewModel.WeatherViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockkObject
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Test
import org.junit.Before

class WeatherViewModelTest {

    @RelaxedMockK
    lateinit var weatherViewModel: WeatherViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        mockkObject(weatherViewModel)
    }


    @Test
    fun getApiClient() {
        every { weatherViewModel.apiClient.retrofitService().getWeather() } returns Observable.just(
            WeatherResponse(
                Currently("cloudy", "Overcast", 58.84, 1582051612),
                Daily(
                    listOf(
                        Data(0.98, 0.97, "rain", "Rain throughout the day.", 1582028400, 1582068300, 62.69, 50.68, 1582002000),
                        Data(0.99, 0.82, "rain", "Rain in the morning and overnight.", 1582114740, 1582154760, 61.61, 45.45, 1582088400),
                        Data(0.99, 0.81, "rain", "Rain throughout the day.", 1582201080, 1582241220, 46.44, 36.48, 1582174800)
                    )
                ),
                Hourly(
                    listOf(
                        DataX("rain", 57.6, 1582048800),
                        DataX("rain", 59.13, 1582052400),
                        DataX("rain", 59.99, 1582056000)
                    )
                )
            )
        )
    }

    @Test
    fun getResponseLiveData() {
        every {weatherViewModel.responseLiveData} throws Exception("Calling handleResponse()")
    }

    @Test
    fun formatTemp() {
        Assert.assertEquals("58°F", weatherViewModel.formatTemp(58.84))
    }
}