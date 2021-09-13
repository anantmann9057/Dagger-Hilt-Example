package com.example.daggerhilt.apiService

import com.example.daggerhilt.data.Cannabis
import retrofit2.http.GET
import retrofit2.http.Query

interface CannabisApi {
    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("cannabis/random_cannabis?size=30")
    suspend fun getCannabis(): ArrayList<Cannabis>

    @GET("cannabis/random_cannabis")
    suspend fun getCannabisWithSize(@Query("size") size: Int): ArrayList<Cannabis>

}