package com.example.weatherapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FiveDaysLayoutBinding
import com.example.weatherapp.models.Data
import com.example.weatherapp.util.Constants.DAY_FORMAT
import com.example.weatherapp.util.Constants.IMG_URL
import com.example.weatherapp.util.Constants.MAGIC_NUMBER
import com.example.weatherapp.util.Constants.PNG_STRING
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

class DailyRecyclerAdapter (var dataList: List<Data>) : RecyclerView.Adapter<DailyRecyclerAdapter.FiveDaysViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FiveDaysViewHolder {

        val binding = DataBindingUtil.inflate<FiveDaysLayoutBinding>(LayoutInflater.from(parent.context), R.layout.five_days_layout, parent, false)
        return FiveDaysViewHolder(binding)

    }

    override fun getItemCount() = dataList.size //number of generatings of calling func

    //take data to correct index
    override fun onBindViewHolder(holder: FiveDaysViewHolder, position: Int) {

        val item = dataList[position]
        holder.bind(item)

    }

    // sending to recycler view -> hourly
    class FiveDaysViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Data) {

            //create binding for card view
            val cardBinding = binding as FiveDaysLayoutBinding

            //let bind data to the card view
            cardBinding.data = item
            cardBinding.DateText.text = SimpleDateFormat(DAY_FORMAT, Locale.US).format(Date(item.time.toLong() * MAGIC_NUMBER)).toString()

            // adding icon with glide
            Glide.with(cardBinding.weatherIcon.context)
                .load(IMG_URL + item.icon + PNG_STRING)
                .into(cardBinding.weatherIcon)

            // creating bundle for passing the data
            val bundle = Bundle()
            bundle.putParcelable("data", cardBinding.data)

            // navigate to following fragment with data bundle
            binding.root.setOnClickListener { view ->
                view.findNavController().navigate(R.id.action_titleFragment_to_detailFragment, bundle)
            }


        }
    }



}