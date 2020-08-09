package com.android.androidappdemos.utils

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.android.androidappdemos.R
import com.google.android.material.snackbar.Snackbar

class snackbarListener : View.OnClickListener {
    override fun onClick(v: View) {
        Log.e("snackbarListener" , "snack action clicked")
    }
}
fun showLongBottomSnackbar(context: AppCompatActivity, message: String) {
    val snackbar = Snackbar.make(
        context.findViewById(R.id.layout_snackbar_container),
        message, Snackbar.LENGTH_LONG
    )
    val snackbarTextView: TextView =
        snackbar.view.findViewById(com.google.android.material.R.id.snackbar_text)
    snackbarTextView.setTextColor(Color.YELLOW)
    snackbar.setAction(R.string.undo, snackbarListener())
    snackbar.show()
}