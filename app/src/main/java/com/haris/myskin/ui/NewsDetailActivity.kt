package com.haris.myskin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haris.myskin.R
import com.haris.myskin.adapter.NewsDetailAdapter
import com.haris.myskin.databinding.ActivityNewsDetailBinding
import com.haris.myskin.model.NewsImage

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.news_detail)

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

        val images = listOf<NewsImage>(
            NewsImage(R.drawable.news_detail1),
            NewsImage(R.drawable.news_content2),
            NewsImage(R.drawable.news_content3),
            NewsImage(R.drawable.news_content4)
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rvNews)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = NewsDetailAdapter(this, images)
    }
}