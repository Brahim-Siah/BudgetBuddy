package com.example.budgetbuddy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amountUsd: Double,
    val category: String,
    val note: String?,
    val currency: String,
    val date: Long
)
