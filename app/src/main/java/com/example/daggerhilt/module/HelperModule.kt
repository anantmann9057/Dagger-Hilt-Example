package com.example.daggerhilt.module

import android.app.Dialog
import android.content.Context
import android.view.Window
import com.example.daggerhilt.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HelperModule @Inject constructor(@ApplicationContext var context: Context) {

}