package com.example.mytestapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mytestapp.fragment.adapter.SubListAdapter
import com.example.mytestapp.fragment.adapter.ViewPagerAdapter
import com.example.mytestapp.repository.DataRepository

class StateViewModal(
    private val dataRepository: DataRepository,
) : ViewModel() {

    // Define ViewModel factory in a companion object
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val dataRepository = DataRepository()
                StateViewModal(
                    dataRepository = dataRepository
                )
            }
        }
    }

    var imageSliderAdapter = ViewPagerAdapter(dataRepository.getStateImages())
    var subListAdapter = SubListAdapter(dataRepository.getUttarPradeshCity())

}