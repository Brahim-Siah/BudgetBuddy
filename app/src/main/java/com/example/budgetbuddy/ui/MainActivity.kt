package com.example.budgetbuddy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.budgetbuddy.R
import com.example.budgetbuddy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        // Load Dashboard by default
        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, DashboardFragment())
        }

        // Bottom Navigation actions
        b.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragmentContainer, DashboardFragment())
                    }
                }
                R.id.nav_expenses -> {
                    supportFragmentManager.commit {
                        replace(R.id.fragmentContainer, ExpensesFragment())
                    }
                }
            }
            true
        }
    }
}
