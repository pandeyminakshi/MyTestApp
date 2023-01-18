package com.example.mytestapp.repository

import com.example.mytestapp.R
import com.example.mytestapp.model.CityListItems
import com.example.mytestapp.model.StateSlider

class DataRepository {

    fun getStateImages() = mutableListOf<StateSlider>().apply {
        add(StateSlider(R.drawable.uttar_pradesh, getUttarPradeshCity()))
        add(StateSlider(R.drawable.madhya_pradesh, getMadhyaPradeshCity()))
        add(StateSlider(R.drawable.rajasthan, getRajasthanCity()))
    }

    fun getUttarPradeshCity() = arrayListOf<CityListItems>().apply {
        add(CityListItems(R.drawable.city_image, "Lucknow"))
        add(CityListItems(R.drawable.city_image, "Agra"))
        add(CityListItems(R.drawable.city_image, "Noida"))
        add(CityListItems(R.drawable.city_image, "Prayagraj"))
        add(CityListItems(R.drawable.city_image, "Varanasi"))
        add(CityListItems(R.drawable.city_image, "Jhansi"))
        add(CityListItems(R.drawable.city_image, "Kanpur"))
        add(CityListItems(R.drawable.city_image, "Mathura"))
        add(CityListItems(R.drawable.city_image, "Ayodhya"))
        add(CityListItems(R.drawable.city_image, "Sultanpur"))
    }

    fun getMadhyaPradeshCity() = arrayListOf<CityListItems>().apply {
        add(CityListItems(R.drawable.city_image, "Bhopal"))
        add(CityListItems(R.drawable.city_image, "Gwalior"))
        add(CityListItems(R.drawable.city_image, "Jabalpur"))
        add(CityListItems(R.drawable.city_image, "Ujjain"))
        add(CityListItems(R.drawable.city_image, "Vidisha"))
        add(CityListItems(R.drawable.city_image, "Indore"))
        add(CityListItems(R.drawable.city_image, "Khandwa"))
        add(CityListItems(R.drawable.city_image, "Sagar"))
        add(CityListItems(R.drawable.city_image, "Satna"))
        add(CityListItems(R.drawable.city_image, "Rewa"))
    }

    fun getRajasthanCity() = arrayListOf<CityListItems>().apply {
        add(CityListItems(R.drawable.city_image, "Jaipur"))
        add(CityListItems(R.drawable.city_image, "Bikaner"))
        add(CityListItems(R.drawable.city_image, "Udaipur"))
        add(CityListItems(R.drawable.city_image, "Jodhpur"))
        add(CityListItems(R.drawable.city_image, "Bharatpur"))
        add(CityListItems(R.drawable.city_image, "Alwar"))
        add(CityListItems(R.drawable.city_image, "Ajmer"))
        add(CityListItems(R.drawable.city_image, "Chittorgarh"))
        add(CityListItems(R.drawable.city_image, "Jaisalmer"))
        add(CityListItems(R.drawable.city_image, "Madhopur"))
    }
}