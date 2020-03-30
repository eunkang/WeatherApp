package com.example.weatherapp

import com.example.weatherapp.viewModel.SecondWeatherViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockkObject
import org.junit.Assert
import org.junit.Test

import org.junit.Before

class SecondWeatherViewModelTest {

    @RelaxedMockK
    lateinit var weatherViewModel: SecondWeatherViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        mockkObject(weatherViewModel)
    }

    @Test
    fun convertDate() {
        Assert.assertEquals("Tue, 18 Feb", weatherViewModel.convertDate(1582002000))
    }

    @Test
    fun convertTime() {
        Assert.assertEquals("7:20 AM", weatherViewModel.convertTime(1582028400))
    }

    @Test
    fun formatTemp() {
        Assert.assertEquals("62°F", weatherViewModel.formatTemp(62.88))
    }

    @Test
    fun convertPercentage() {
        Assert.assertEquals("97%", weatherViewModel.convertPercentage(0.97))
    }
}