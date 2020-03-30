package com.example.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.viewModel.WeatherViewModel
import com.example.weatherapp.adapter.DailyRecyclerAdapter
import com.example.weatherapp.adapter.HourlyRecyclerAdapter
import com.example.weatherapp.databinding.FragmentTitleBinding
import com.example.weatherapp.util.Constants.IMG_URL
import com.example.weatherapp.util.Constants.PNG_STRING

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    private lateinit var viewModel: WeatherViewModel // initializing view model


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // initiating the binder by inflating the layout
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        //calling ViewModel providers
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        // Adding data binding for VM
        binding.data = viewModel

        // Attaching observer to live data for current details
        viewModel.responseLiveData.observe(viewLifecycleOwner, Observer { newCurr ->
            binding.currTempText.text = viewModel.formatTemp(newCurr.currently.temperature)
            binding.currCondText.text = newCurr.currently.summary

            //icon using glide
            Glide.with(this)
                .load(IMG_URL + newCurr.currently.icon + PNG_STRING)
                .into(binding.WeatherIcon)

        })

        // Attaching observer to LiveData object
        viewModel.responseLiveData.observe(viewLifecycleOwner, Observer { recyclerView ->
            binding.TodayHourlyRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.TodayHourlyRecycler.adapter = HourlyRecyclerAdapter(viewModel.responseLiveData.value!!.hourly.data)
        })


        // Attaching observer to second LiveData object
        viewModel.responseLiveData.observe(viewLifecycleOwner, Observer { recyclerView2 ->
            binding.fiveDaysRecycler.layoutManager = LinearLayoutManager(context)
            binding.fiveDaysRecycler.adapter = DailyRecyclerAdapter(viewModel.responseLiveData.value!!.daily.data)
        })

        return binding.root

    }

}
