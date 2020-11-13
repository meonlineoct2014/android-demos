package com.android.androidappdemos.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast

fun showLongToastAtBottom(context: Context, message: String) {
    val toast : Toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
    toast.setGravity(Gravity.TOP, 0,0)
    toast.show()
}

fun showShortToastAtBottom(context: Context, message: String) {
    val toast : Toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.TOP, 0,0)
    toast.show()
}

