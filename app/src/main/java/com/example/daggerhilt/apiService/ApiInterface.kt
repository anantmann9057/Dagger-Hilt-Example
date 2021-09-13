package com.example.daggerhilt.apiService

import com.example.daggerhilt.data.Cannabis
import com.example.daggerhilt.data.PlaceHolder
import com.example.daggerhilt.data.Restaurant
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("cannabis/random_cannabis?size=30")
    suspend fun getCannabis(): ArrayList<Cannabis>

    @GET("cannabis/random_cannabis")
    suspend fun getCannabisWithSize(@Query("size") size: Int): ArrayList<Cannabis>

    @GET("placeholdit/random_placeholdit?size=30")
    suspend fun getPlaceHolder(): ArrayList<PlaceHolder>

    @GET("restaurant/random_restaurant?size=30")
    suspend fun getRestaurant(): ArrayList<Restaurant>
}