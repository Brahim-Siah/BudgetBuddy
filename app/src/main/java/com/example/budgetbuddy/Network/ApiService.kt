package com.example.budgetbuddy.network

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v6/latest/{base}")
    suspend fun getRates(@Path("base") base: String): CurrencyResponse

}
