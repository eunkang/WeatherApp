package com.example.weatherapp.viewModel

import androidx.lifecycle.*
import com.example.weatherapp.application.WeatherApplication
import com.example.weatherapp.models.WeatherResponse
import com.example.weatherapp.network.WeatherApiClient
import com.example.weatherapp.util.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.String

class WeatherViewModel : ViewModel() {

    @Inject
    lateinit var apiClient: WeatherApiClient

    private val _responseLiveData = MutableLiveData<WeatherResponse>()
    val responseLiveData: LiveData<WeatherResponse>
        get() = _responseLiveData //accessing getter

    private val compositeDisposable: CompositeDisposable? = CompositeDisposable()

    private fun getWeatherApi() = compositeDisposable?.add (
        apiClient.retrofitService().getWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse)
    )

    init {
        WeatherApplication.instance.component.inject(this)
        getWeatherApi()
    }


    private fun handleResponse(response: WeatherResponse) {
        _responseLiveData.value = response
    }

    // formatting temperature
    fun formatTemp(temp: Double) = String.format(temp.toInt().toString() + Constants.FAHRENHEIT)

    override fun onCleared() {
        super.onCleared()
        compositeDisposable?.dispose()
    }

}
