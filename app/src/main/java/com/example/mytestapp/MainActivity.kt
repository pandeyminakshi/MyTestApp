package com.example.mytestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.mytestapp.databinding.ActivityMainBinding
import com.example.mytestapp.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        fragmentStart()
    }

    private fun fragmentStart() {
        val manager: FragmentManager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.afragment, HomeFragment(), "YOUR_FRAGMENT_STRING_TAG")
        transaction.commit()
    }
}