package com.sarchimarcus.bukstore.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sarchimarcus.bukstore.models.Volumes
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface BookApiService{
    @GET("volumes")
    fun getBooks(@Query("q") query: String):
    //Call<Volumes>
           Deferred<Volumes>
}

object BookApi{
    val retrofitService:BookApiService by lazy {
        retrofit.create(BookApiService::class.java) //return retrofit object that implements BookApiService
    }
}


