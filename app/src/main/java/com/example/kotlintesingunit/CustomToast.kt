package com.example.kotlintesingunit

import android.content.Context
import android.widget.Toast

class CustomToast {
    public fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}