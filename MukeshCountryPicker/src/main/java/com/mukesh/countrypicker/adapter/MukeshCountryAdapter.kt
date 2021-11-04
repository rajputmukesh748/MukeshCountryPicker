package com.mukesh.countrypicker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mukesh.countrypicker.countryinterface.SelectCountry
import com.mukesh.countrypicker.databinding.CountryItemBinding
import com.mukesh.countrypicker.dataclass.CountryData
import com.mukesh.countrypicker.dataclass.MukeshCountryUI

class MukeshCountryAdapter(private val mukeshCountryUI: MukeshCountryUI) : ListAdapter<CountryData, CountryViewHolder>(MukeshCountryDiffUtil()) {

    lateinit var selectCountry : SelectCountry

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CountryViewHolder(
            CountryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        try {
            val dataClass = getItem(position)
            holder.bind(dataClass,mukeshCountryUI)

            holder.itemView.setOnClickListener {
                if (::selectCountry.isInitialized)
                    selectCountry.selectedCountry(dataClass.countryName)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}