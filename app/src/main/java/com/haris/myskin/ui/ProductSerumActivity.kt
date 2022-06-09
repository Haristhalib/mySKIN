package com.haris.myskin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haris.myskin.R
import com.haris.myskin.databinding.ActivityProductSerumBinding

class ProductSerumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductSerumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductSerumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.serumtl)

        binding.bthome.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }
        binding.btscan.setOnClickListener {
//            val intent = Intent(this, CameraActivity::class.java)
//            startActivity(intent)
        }
        binding.btproduct.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }
        binding.btaboutus.setOnClickListener {
//            val intent = Intent(this, AboutusActivity::class.java)
//            startActivity(intent)
        }
    }
}