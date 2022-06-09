package com.haris.myskin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haris.myskin.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var activityProductBinding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityProductBinding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(activityProductBinding.root)

        activityProductBinding.ivtoner.setOnClickListener{
            val intent = Intent(this, ProductTonerActivity::class.java)
            startActivity(intent)
        }
        activityProductBinding.ivsunscreen.setOnClickListener{
            val intent = Intent(this, ProductSunscreenActivity::class.java)
            startActivity(intent)
        }
        activityProductBinding.ivserum.setOnClickListener{
            val intent = Intent(this, ProductSerumActivity::class.java)
            startActivity(intent)
        }
        activityProductBinding.ivmoist.setOnClickListener{
            val intent = Intent(this, ProductMoistActivity::class.java)
            startActivity(intent)
        }

    }
}