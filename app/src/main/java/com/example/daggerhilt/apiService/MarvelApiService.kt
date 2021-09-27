package com.example.daggerhilt.apiService

import com.example.daggerhilt.data.Marvel
import com.example.daggerhilt.data.ResultsItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {
    companion object {
        const val MARVEL_URL = "https://gateway.marvel.com/"
    }

    @GET("v1/public/characters")
    suspend fun getMarvelData(
        @Query("ts") timeStamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): ArrayList<ResultsItem>
}