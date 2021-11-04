package com.mukesh.countrypicker.mukeshcountryclasses

import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.mukesh.countrypicker.adapter.MukeshCountryAdapter
import com.mukesh.countrypicker.countryinterface.SelectCountry
import com.mukesh.countrypicker.databinding.MukeshCountryBottomSheetBinding
import com.mukesh.countrypicker.dataclass.CountryData
import com.mukesh.countrypicker.dataclass.MukeshCountryUI
import java.util.*
import kotlin.collections.ArrayList

class MukeshCountryBottom : AppCompatActivity(), SelectCountry {

    companion object{
        @JvmStatic
        lateinit var mukeshCountryUI : MukeshCountryUI
    }

    private val binding by lazy { MukeshCountryBottomSheetBinding.inflate(layoutInflater) }
    private val countryList by lazy { ArrayList<CountryData>() }
    private val adapter by lazy { MukeshCountryAdapter(mukeshCountryUI) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCountries.adapter = adapter
        adapter.selectCountry = this
        handleUI()
        getCountryList()
        searchData()
    }


    private fun handleUI() = try {
        binding.clSearchView.isVisible = mukeshCountryUI.isSearchEnable
        binding.etSearchView.setTextColor(mukeshCountryUI.textColor)
        binding.mainView.setBackgroundColor(mukeshCountryUI.backGroundColor)
    }catch (e:Exception){
        e.printStackTrace()
    }


    private fun getCountryList() = try {
        countryList.clear()
        val manager: TelephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        Locale.getISOCountries().forEach { countries ->
            Locale("", countries).apply {
                countryList.add(
                    CountryData(
                        countryIso2 = country,
                        countryName = displayName
                    )
                )
            }
        }
        adapter.submitList(countryList)
    } catch (e: Exception) {
        e.printStackTrace()
    }


    private fun searchData() = try {
        binding.etSearchView.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrEmpty()) adapter.submitList(countryList)
            else adapter.submitList(countryList.filter {
                it.countryName.startsWith(text.toString(), true)
            })
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }


    /**
     * Selected Country
     * */
    override fun selectedCountry(countryName: String) {
        mukeshCountryUI.selectedCountry(countryName)
        finish()
    }

}