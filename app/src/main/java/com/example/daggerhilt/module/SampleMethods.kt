package com.example.daggerhilt.module

import android.content.Context
import android.widget.Toast
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SampleMethods @Inject constructor() {


    @Singleton
    fun showToast(context: Context, mssg: Any) =
        Toast.makeText(context, "$mssg", Toast.LENGTH_SHORT).show()

}