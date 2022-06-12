package com.haris.myskin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haris.myskin.R
import com.haris.myskin.adapter.NewsDetailAdapter
import com.haris.myskin.model.NewsImage

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

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