package com.felipevelez.salesmanagementproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.felipevelez.salesmanagementproject.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)
    }
}