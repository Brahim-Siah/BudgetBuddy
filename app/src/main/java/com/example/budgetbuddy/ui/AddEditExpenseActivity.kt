package com.example.budgetbuddy.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.budgetbuddy.data.AppDatabase
import com.example.budgetbuddy.data.Expense
import com.example.budgetbuddy.databinding.ActivityAddEditExpenseBinding
import com.example.budgetbuddy.network.RetrofitInstance
import kotlinx.coroutines.launch

class AddEditExpenseActivity : AppCompatActivity() {

    private lateinit var b: ActivityAddEditExpenseBinding
    private val dao by lazy { AppDatabase.getDatabase(this).expenseDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAddEditExpenseBinding.inflate(layoutInflater)
        setContentView(b.root)

        val categories = listOf("Food", "Bills", "Transport", "Shopping", "Other")
        b.spCategory.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories)

        val currencies = listOf("USD", "EUR", "GBP", "CAD", "JPY")
        b.spCurrency.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, currencies)

        b.btnSave.setOnClickListener { saveExpense() }
    }

    private fun saveExpense() {
        val amountStr = b.etAmount.text.toString().trim()
        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Enter an amount", Toast.LENGTH_SHORT).show()
            return
        }

        val amount = amountStr.toDouble()
        val category = b.spCategory.selectedItem.toString()
        val currency = b.spCurrency.selectedItem.toString()
        val note = b.etNote.text.toString().trim().ifEmpty { null }

        lifecycleScope.launch {
            val amountUsd =
                if (currency == "USD") amount
                else {
                    val resp = RetrofitInstance.api.getRates("USD")
                    val rate = resp.rates[currency] ?: 1.0
                    amount / rate
                }

            val expense = Expense(
                amountUsd = amountUsd,
                category = category,
                note = note,
                currency = currency,
                date = System.currentTimeMillis()
            )

            dao.insert(expense)
            finish()
        }
    }
}
