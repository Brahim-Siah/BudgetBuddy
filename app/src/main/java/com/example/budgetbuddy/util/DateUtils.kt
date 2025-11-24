package com.example.budgetbuddy.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun formatDate(ms: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.format(Date(ms))
    }
}
