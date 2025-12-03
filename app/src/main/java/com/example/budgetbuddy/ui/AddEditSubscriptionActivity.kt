package com.example.budgetbuddy.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.budgetbuddy.data.AppDatabase
import com.example.budgetbuddy.data.Subscription
import com.example.budgetbuddy.databinding.ActivityAddEditSubscriptionBinding
import kotlinx.coroutines.launch

class AddEditSubscriptionActivity : AppCompatActivity() {

    private lateinit var b: ActivityAddEditSubscriptionBinding
    private var subscriptionId: Int? = null
    private val dao by lazy { AppDatabase.getDatabase(this).subscriptionDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAddEditSubscriptionBinding.inflate(layoutInflater)
        setContentView(b.root)

        subscriptionId = intent.getIntExtra("subscriptionId", -1).takeIf { it != -1 }

        if (subscriptionId != null) {
            loadSubscription(subscriptionId!!)
        }

        b.btnSave.setOnClickListener { saveSubscription() }
        b.btnDelete.setOnClickListener { deleteSubscription() }
    }

    private fun loadSubscription(id: Int) {
        lifecycleScope.launch {
            val sub = dao.getSubscriptionById(id)

            if (sub != null) {
                b.etName.setText(sub.name)
                b.etCost.setText(sub.monthlyCost.toString())
                b.btnDelete.visibility = android.view.View.VISIBLE
            }
        }
    }

    private fun saveSubscription() {
        val name = b.etName.text.toString().trim()
        val cost = b.etCost.text.toString().toDoubleOrNull() ?: 0.0

        if (name.isEmpty()) {
            Toast.makeText(this, "Enter a name", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            if (subscriptionId == null) {
                dao.insert(Subscription(name = name, monthlyCost = cost))
            } else {
                dao.update(Subscription(id = subscriptionId!!, name = name, monthlyCost = cost))
            }
            finish()
        }
    }

    private fun deleteSubscription() {
        lifecycleScope.launch {
            subscriptionId?.let {
                val sub = dao.getSubscriptionById(it)
                if (sub != null) dao.delete(sub)
            }
            finish()
        }
    }
}
