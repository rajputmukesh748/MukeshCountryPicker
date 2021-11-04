package com.mukesh.countrypicker

import android.content.Intent
import android.graphics.Color
import androidx.fragment.app.FragmentActivity
import com.mukesh.countrypicker.dataclass.MukeshCountryUI
import com.mukesh.countrypicker.mukeshcountryclasses.MukeshCountryBottom

/**
 * @author White Shark
 * @Date 11/5/2021
 * @MukeshCountryPicker class is used
 * for initialize a Country Picker.
 *
 * @context for initialize a activity.
 * @isFlagEnable is used for show or hide a country flag, by default its true.
 * @isCountryName is used for show or hide country name, by default its true.
 * @isSearchEnable is used for show or hide Search view, by default its true.
 * @textColor is used for change text color according to over requirements.
 * @backGroundColor is used for change a background color according to over requirements.
 * @selectedResult is used for get selected result.
 * */
class MukeshCountryPicker(
    private var context: () -> FragmentActivity,
    private var isFlagEnable: () -> Boolean = { true },
    private var isCountryName: () -> Boolean = { true },
    private var isSearchEnable: () -> Boolean = { true },
    private var textColor: () -> Int = { Color.BLACK },
    private var backGroundColor: () -> Int = { Color.WHITE },
    private var selectedResult: (selectedResult: String) -> Unit
) {

    /**
     * Initialize data class for store user values
     * for customize UI text color and background
     * color and also handle hide some functionality.
     * */
    private val mukeshCountryUI by lazy { MukeshCountryUI(selectedCountry = selectedResult) }


    /**
     * when call class init
     * method will automatically
     * call this method.
     * */
    init {
        setCountryUI()
    }


    /**
     * @setCountryUi method for
     * handle or set UI data
     * which user set in data class
     * and customize there UI.
     * */
    private fun setCountryUI() = run {
        mukeshCountryUI.context = context.invoke()
        mukeshCountryUI.isFlagEnable = isFlagEnable.invoke()
        mukeshCountryUI.isCountryName = isCountryName.invoke()
        mukeshCountryUI.isSearchEnable = isSearchEnable.invoke()
        mukeshCountryUI.textColor = textColor.invoke()
        mukeshCountryUI.backGroundColor = backGroundColor.invoke()
    }


    /**
     * @show method call is mandatory
     * otherwise country picker UI
     * not open or not show.
     * */
    fun show() : MukeshCountryPicker{
        mukeshCountryUI.context?.let {
            MukeshCountryBottom.mukeshCountryUI = mukeshCountryUI
            Intent(it, MukeshCountryBottom::class.java).apply {
                it.startActivity(this)
            }
        }
        return this
    }

}