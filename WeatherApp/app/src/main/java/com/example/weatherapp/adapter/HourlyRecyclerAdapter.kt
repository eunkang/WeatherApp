package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.databinding.HourlyTempBinding
import com.example.weatherapp.models.DataX
import com.example.weatherapp.util.Constants.HOUR_FORMAT
import com.example.weatherapp.util.Constants.IMG_URL
import com.example.weatherapp.util.Constants.MAGIC_NUMBER
import com.example.weatherapp.util.Constants.PNG_STRING
import java.text.SimpleDateFormat
import java.util.Locale

class HourlyRecyclerAdapter (var dataList: List<DataX>) : RecyclerView.Adapter<HourlyRecyclerAdapter.HourlyTempViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HourlyTempViewHolder {

        val binding = DataBindingUtil.inflate<HourlyTempBinding>(LayoutInflater.from(parent.context), R.layout.hourly_temp, parent, false)
        return HourlyTempViewHolder(binding)

    }

    override fun getItemCount() = dataList.size  //number of generating of calling func

    //take data to correct index
    override fun onBindViewHolder(holder: HourlyTempViewHolder, position: Int) {

        val item = dataList[position]
        holder.bind(item)

    }

    // sending to recycler view -> hourly
    class HourlyTempViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataX) {

            //create binding for card view
            val cardBinding = binding as HourlyTempBinding

            //let bind data to the card view
            cardBinding.data = item

            // format time/date & display on the textView
            val getDayFormat = SimpleDateFormat(HOUR_FORMAT, Locale.US)
            cardBinding.hourText.text = getDayFormat.format(item.time.toLong() * MAGIC_NUMBER)

            // adding icon with glide
            Glide.with(cardBinding.weatherIcon.context)
                .load(IMG_URL + item.icon + PNG_STRING)
                .into(cardBinding.weatherIcon)

        }
    }


}