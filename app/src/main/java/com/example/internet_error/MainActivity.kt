package com.example.internet_error

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internet_error.databinding.ActivityMainBinding

internal class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupListeners()
    }

    private fun setupBinding() {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }

    private fun setupListeners() {
        _binding.testConnectivity.setOnClickListener { updateTitle() }
    }

    private fun updateTitle() {
        val isConnected = CheckNetworkConnection(this@MainActivity).isConnected()

        _binding.title.text = if (isConnected) {
            getString(R.string.title_connected)
        } else {
            getString(R.string.title_disconnected)
        }
    }
}