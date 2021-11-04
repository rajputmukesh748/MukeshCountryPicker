package com.practice.countrypicker

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentActivity
import com.mukesh.countrypicker.MukeshCountryPicker
import com.practice.countrypicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MukeshCountryPicker(
            context = { this },
            isFlagEnable = { true },
            isCountryName = { true },
            isSearchEnable = { true },
            textColor = { Color.BLACK },
            backGroundColor = { Color.WHITE },
            selectedResult = { result ->
                Log.e("Selected Country is", result)
            }
        ).show()
    }


}