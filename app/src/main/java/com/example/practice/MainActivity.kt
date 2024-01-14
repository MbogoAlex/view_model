package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
//    private var count = 0
    private lateinit var viewModel:MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val countDisplay = findViewById<TextView>(R.id.tvCount)
////        countDisplay.text = "0"
//        countDisplay.text = viewModel.count.toString()
        val countButton = findViewById<Button>(R.id.medianCount)

        viewModel.count.observe(this){
            countDisplay.text = "$it"
        }

        countButton.setOnClickListener {
//            count++
            viewModel.updateCount()
//            countDisplay.text = viewModel.count.toString()
        }
    }
}