package com.example.daggerhilt.module

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceModule @Inject constructor(@ApplicationContext var context: Context) {
    private val USER_PREFS = "base_prefs"
    private val IS_FIRST_TIME = "isFirstTime"
    private val RESUME_PREF = "resume_pref"

    private val timePref = "timePref"
    private val userToken = "userToken"
    private val userPhone = "userPhone"
    private val pincode = "pincode"
    private val user = "user"
    private val url = "url"
    private var appSharedPrefs: SharedPreferences =
        context.getSharedPreferences(USER_PREFS, Activity.MODE_PRIVATE)
    private var prefsEditor: SharedPreferences.Editor = appSharedPrefs.edit()

    /* ---------------- ------------------------*/
    fun setUserToken(userToken: String?) {
        prefsEditor.putString(this.userToken, userToken).apply()
    }

    fun getUserToken(): String? {
        return appSharedPrefs.getString(userToken, "")
    }


}