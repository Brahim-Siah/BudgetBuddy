package com.example.budgetbuddy.network

data class CurrencyResponse(
    val result: String,
    val base_code: String,
    val rates: Map<String, Double>
)
