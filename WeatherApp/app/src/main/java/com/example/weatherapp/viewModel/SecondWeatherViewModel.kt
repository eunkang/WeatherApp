package com.example.weatherapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.util.Constants.DAY_DATE_FORMAT
import com.example.weatherapp.util.Constants.DEC_TO_PERCENTAGE
import com.example.weatherapp.util.Constants.FAHRENHEIT
import com.example.weatherapp.util.Constants.HOUR_MINUTE_FORMAT
import com.example.weatherapp.util.Constants.MAGIC_NUMBER
import kotlin.String
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date


class SecondWeatherViewModel : ViewModel() {

    // format functions
    fun convertDate(date: Int) = SimpleDateFormat(DAY_DATE_FORMAT, Locale.US).format(Date(date.toLong() * MAGIC_NUMBER)).toString()
    fun convertTime(time: Int) = SimpleDateFormat(HOUR_MINUTE_FORMAT, Locale.US).format(Date(time.toLong() * MAGIC_NUMBER)).toString()
    fun formatTemp(temp: Double) = String.format(temp.toInt().toString() + FAHRENHEIT)
    fun convertPercentage(percentage: Double) = DecimalFormat(DEC_TO_PERCENTAGE).format(percentage).toString()

}