package com.haris.myskin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haris.myskin.R
import com.haris.myskin.databinding.ActivityNewsBinding
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


    }
}