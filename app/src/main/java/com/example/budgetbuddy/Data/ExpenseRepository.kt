package com.example.budgetbuddy.data

class ExpenseRepository(private val dao: ExpenseDao) {

    fun getExpenses() = dao.getAllExpenses()

    fun getTotal() = dao.getTotalSpending()

    suspend fun insert(expense: Expense) = dao.insert(expense)

    suspend fun update(expense: Expense) = dao.update(expense)

    suspend fun delete(expense: Expense) = dao.delete(expense)
}
