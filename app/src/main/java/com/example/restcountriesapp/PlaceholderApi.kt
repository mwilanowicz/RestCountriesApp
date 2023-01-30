package com.example.restcountriesapp


import retrofit2.Call
import retrofit2.http.GET

interface PlaceholderApi {
    @GET("v2/all")
    fun getCountries(): Call<List<Country>>
}