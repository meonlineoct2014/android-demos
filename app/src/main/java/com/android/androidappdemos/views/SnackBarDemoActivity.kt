package com.android.androidappdemos.views

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.android.androidappdemos.R
import com.android.androidappdemos.utils.showLongBottomSnackbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_snack_bar_demo.*

class SnackBarDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar_demo)
        showLongBottomSnackbar(this, "This is snackbar text with context")
    }
}