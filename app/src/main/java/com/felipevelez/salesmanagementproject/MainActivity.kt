package com.felipevelez.salesmanagementproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.felipevelez.salesmanagementproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

    }
    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "Nos vemos Pronto", Toast.LENGTH_SHORT).show()
    }
}
