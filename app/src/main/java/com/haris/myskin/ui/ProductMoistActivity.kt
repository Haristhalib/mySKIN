package com.haris.myskin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haris.myskin.R
import com.haris.myskin.databinding.ActivityProductMoistBinding

class ProductMoistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductMoistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductMoistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.moisttl)

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