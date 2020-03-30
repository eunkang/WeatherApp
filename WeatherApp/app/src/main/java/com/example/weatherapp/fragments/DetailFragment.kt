package com.example.weatherapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.viewModel.SecondWeatherViewModel
import com.example.weatherapp.databinding.FragmentDetailBinding
import com.example.weatherapp.models.Data
import com.example.weatherapp.util.Constants.IMG_URL
import com.example.weatherapp.util.Constants.PNG_STRING

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    private lateinit var viewModel: SecondWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,
            R.layout.fragment_detail, container,false)

        //calling ViewModel providers
        viewModel = ViewModelProvider(this).get(SecondWeatherViewModel::class.java)

        // adding data binding to VM
        binding.data = viewModel

        // receiving data from daily recycler
        val bundle = arguments!!.getParcelable<Data>("data")

        // displaying data on xml
        binding.DateText.text = viewModel.convertDate(bundle!!.time)
        binding.CondText.text = bundle.summary
        binding.maxTempText.text = viewModel.formatTemp(bundle.temperatureMax)
        binding.minTempText.text = viewModel.formatTemp(bundle.temperatureMin)
        binding.sunriseTimeText.text = viewModel.convertTime(bundle.sunriseTime)
        binding.sunsetTimeText.text = viewModel.convertTime(bundle.sunsetTime)
        binding.humidityPerText.text = viewModel.convertPercentage(bundle.humidity)
        binding.cloudCoverNumText.text = viewModel.convertPercentage(bundle.cloudCover)

        //icon using glide
        Glide.with(this)
            .load(IMG_URL + bundle.icon + PNG_STRING)
            .into(binding.weatherIcon)


        return binding.root

    }


}
