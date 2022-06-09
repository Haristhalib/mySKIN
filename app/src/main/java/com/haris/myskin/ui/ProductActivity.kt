package com.haris.myskin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haris.myskin.R
import com.haris.myskin.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.product)

        binding.ivtoner.setOnClickListener{
            val intent = Intent(this, ProductTonerActivity::class.java)
            startActivity(intent)
        }
        binding.ivsunscreen.setOnClickListener{
            val intent = Intent(this, ProductSunscreenActivity::class.java)
            startActivity(intent)
        }
        binding.ivserum.setOnClickListener{
            val intent = Intent(this, ProductSerumActivity::class.java)
            startActivity(intent)
        }
        binding.ivmoist.setOnClickListener{
            val intent = Intent(this, ProductMoistActivity::class.java)
            startActivity(intent)
        }
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