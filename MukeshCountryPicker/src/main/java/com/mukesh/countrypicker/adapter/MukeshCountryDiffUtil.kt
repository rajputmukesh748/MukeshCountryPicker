package com.mukesh.countrypicker.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mukesh.countrypicker.dataclass.CountryData

class MukeshCountryDiffUtil : DiffUtil.ItemCallback<CountryData>() {
    override fun areItemsTheSame(oldItem: CountryData, newItem: CountryData) =
        oldItem.countryName == newItem.countryName

    override fun areContentsTheSame(oldItem: CountryData, newItem: CountryData) =
        oldItem == newItem
}