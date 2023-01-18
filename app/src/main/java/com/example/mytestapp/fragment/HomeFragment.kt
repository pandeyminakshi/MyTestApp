package com.example.mytestapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import com.example.mytestapp.databinding.FragmentHomeBinding
import com.example.mytestapp.repository.DataRepository
import com.example.mytestapp.viewmodel.StateViewModal


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val dataRepository: DataRepository = DataRepository()
    private val viewModel: StateViewModal by viewModels { StateViewModal.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setState()
        setSublistItems()
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.subListAdapter.filter.filter(newText.toString())
                return true
            }

        })
    }

    private fun setSublistItems() {
        binding.recyclerView.adapter = viewModel.subListAdapter
    }

    private fun setState() {
        binding.viewPager.adapter = viewModel.imageSliderAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.addOnPageChangeListener(
            object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    viewModel.subListAdapter.updateList(dataRepository.getStateImages()[position].sublistItems)
                }

                override fun onPageScrollStateChanged(state: Int) {

                }

            })
    }
}