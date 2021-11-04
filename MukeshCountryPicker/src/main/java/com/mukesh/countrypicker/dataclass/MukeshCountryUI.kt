package com.mukesh.countrypicker.dataclass

import android.graphics.Color
import androidx.fragment.app.FragmentActivity
import java.io.Serializable

data class MukeshCountryUI(
    var context: FragmentActivity? = null,
    var isFlagEnable: Boolean = true,
    var isCountryName: Boolean = true,
    var isSearchEnable: Boolean = true,
    var textColor: Int = Color.BLACK,
    var backGroundColor: Int = Color.WHITE,
    var selectedCountry: (selectedCountry: String) -> Unit
): Serializable
