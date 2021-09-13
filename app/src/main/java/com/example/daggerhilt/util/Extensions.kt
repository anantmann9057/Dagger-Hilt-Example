package com.example.daggerhilt

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.showToast(mssg: Any) {
    Toast.makeText(this, "$mssg", Toast.LENGTH_SHORT).show()
}

fun showLog(mssg: Any) {
    Log.e("${R.string.app_name}", "$mssg")
}