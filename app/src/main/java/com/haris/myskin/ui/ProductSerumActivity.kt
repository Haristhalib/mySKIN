package com.haris.myskin.ui

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haris.myskin.R
import com.haris.myskin.adapter.ProductMoistAdapter
import com.haris.myskin.adapter.ProductSerumAdapter
import com.haris.myskin.databinding.ActivityProductSerumBinding
import com.haris.myskin.model.ProductImage

class ProductSerumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductSerumBinding

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == NewsActivity.REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    this,
                    getString(R.string.restricted),
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    private fun allPermissionsGranted() = NewsActivity.REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductSerumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.serumtl)

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                NewsActivity.REQUIRED_PERMISSIONS,
                NewsActivity.REQUEST_CODE_PERMISSIONS
            )
        }

        binding.bthome.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }
        binding.btscan.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }

        binding.btaboutus.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)

            val images = listOf<ProductImage>(
                ProductImage(R.drawable.productlist),
                ProductImage(R.drawable.productlist),
                ProductImage(R.drawable.productlist),
                ProductImage(R.drawable.productlist),
                ProductImage(R.drawable.productlist),
                ProductImage(R.drawable.productlist)
            )


            val recyclerView = findViewById<RecyclerView>(R.id.rvSerum)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = ProductSerumAdapter(this, images)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}