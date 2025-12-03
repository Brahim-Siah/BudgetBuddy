package com.example.budgetbuddy.data

import androidx.room.TypeConverter
import java.time.LocalDate

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDate? {
        // Convert a Long from the database back to a LocalDate
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        // Convert a LocalDate from your code into a Long to store in the database
        return date?.toEpochDay()
    }

    // Add other converters here if you use other custom types like BigDecimal, etc.
}
