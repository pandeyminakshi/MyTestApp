package com.example.mytestapp.model

import androidx.annotation.DrawableRes

data class StateSlider(
    @DrawableRes var imageResource: Int,
    var sublistItems: ArrayList<CityListItems>
)