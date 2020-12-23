package com.android.androidappdemos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.androidappdemos.R
import com.android.androidappdemos.databinding.ActivityConstraintdemoBinding

class ConstraintDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstraintdemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintdemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView6.setOnClickListener {
            Toast.makeText(this, "Text view clicked", Toast.LENGTH_LONG).show()
        }
    }
}