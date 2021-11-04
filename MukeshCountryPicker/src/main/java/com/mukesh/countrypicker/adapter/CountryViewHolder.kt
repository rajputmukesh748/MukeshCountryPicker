package com.mukesh.countrypicker.adapter

import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mukesh.countrypicker.databinding.CountryItemBinding
import com.mukesh.countrypicker.dataclass.CountryData
import com.mukesh.countrypicker.dataclass.MukeshCountryUI
import java.util.*

class CountryViewHolder(private val binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dataClass : CountryData, mukeshCountryUI: MukeshCountryUI){
        binding.root.context?.let { context ->

            binding.tvCountryName.text = dataClass.countryName

            binding.tvCountryName.isVisible = mukeshCountryUI.isCountryName
            binding.ivCountryImage.isVisible = mukeshCountryUI.isFlagEnable
            binding.tvCountryName.setTextColor(mukeshCountryUI.textColor)

            try {
                val intData = ContextCompat.getDrawable(
                    context, context.resources.getIdentifier(
                        "country_flag_${dataClass.countryIso2.lowercase(Locale.getDefault())}",
                        "drawable",
                        context.packageName
                    )
                )
                binding.ivCountryImage.setImageDrawable(intData)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}