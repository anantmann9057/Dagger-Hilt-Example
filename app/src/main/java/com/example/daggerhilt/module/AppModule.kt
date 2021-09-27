package com.example.daggerhilt.module

import com.example.daggerhilt.AUTH_TOKEN
import com.example.daggerhilt.apiService.ApiInterface
import com.example.daggerhilt.apiService.MarvelApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule() {

    @Provides
    @Singleton
    fun interceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun OkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor())
        .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val requestBuilder = chain.request().newBuilder()
                    .header(
                        "Authorization",
                        "Bearer$AUTH_TOKEN"
                    )
                return chain.proceed(requestBuilder.build())
            }

        })
        .build()

    @Provides
    @Singleton
    @Named("ApiService")
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(ApiInterface.BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    @Named("ApiService")
    fun provideCannabisApi(retrofit: Retrofit): ApiInterface = providesRetrofit()
        .create(ApiInterface::class.java)


    @Provides
    @Singleton
    @Named("MarvelService")
    fun providesMarvelRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(MarvelApiService.MARVEL_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    @Named("MarvelService")
    fun provideMarvelApi(retrofit: Retrofit): MarvelApiService = providesMarvelRetrofit()
        .create(MarvelApiService::class.java)


}