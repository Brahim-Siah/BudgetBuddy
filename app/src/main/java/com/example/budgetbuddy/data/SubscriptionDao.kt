package com.example.budgetbuddy.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SubscriptionDao {

    @Insert
    suspend fun insert(subscription: Subscription)

    @Update
    suspend fun update(subscription: Subscription)

    @Delete
    suspend fun delete(subscription: Subscription)

    @Query("SELECT * FROM subscriptions ORDER BY name ASC")
    fun getAllSubscriptions(): Flow<List<Subscription>>

    @Query("SELECT SUM(monthlyCost) FROM subscriptions")
    fun getTotalMonthlyCost(): Flow<Double?>

    @Query("SELECT * FROM subscriptions WHERE id = :id LIMIT 1")
    suspend fun getSubscriptionById(id: Int): Subscription?
}
