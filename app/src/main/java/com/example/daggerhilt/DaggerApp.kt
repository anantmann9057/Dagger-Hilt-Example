package com.example.daggerhilt

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DaggerApp : Application() {
    lateinit var mContext: Context
    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

    fun getContext(): Context {
        return mContext
    }
}