package com.haris.myskin.ui

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.haris.myskin.R
import com.haris.myskin.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding

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
                    "Tidak mendapatkan permission.",
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
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.product)

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                NewsActivity.REQUIRED_PERMISSIONS,
                NewsActivity.REQUEST_CODE_PERMISSIONS
            )
        }

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
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }

        binding.btaboutus.setOnClickListener {
//            val intent = Intent(this, AboutusActivity::class.java)
//            startActivity(intent)
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}