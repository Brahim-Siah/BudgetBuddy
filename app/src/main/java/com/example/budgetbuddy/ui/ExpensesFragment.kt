package com.example.budgetbuddy.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetbuddy.data.AppDatabase
import com.example.budgetbuddy.databinding.FragmentExpensesBinding
import com.example.budgetbuddy.ui.adapter.ExpenseAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ExpensesFragment : Fragment() {

    private var _b: FragmentExpensesBinding? = null
    private val b get() = _b!!
    private lateinit var adapter: ExpenseAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _b = FragmentExpensesBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ExpenseAdapter { expense ->
            val i = Intent(requireContext(), AddEditExpenseActivity::class.java)
            i.putExtra("expenseId", expense.id)
            startActivity(i)
        }

        b.rvExpenses.layoutManager = LinearLayoutManager(requireContext())
        b.rvExpenses.adapter = adapter

        val dao = AppDatabase.getDatabase(requireContext()).expenseDao()

        viewLifecycleOwner.lifecycleScope.launch {
            dao.getAllExpenses().collectLatest {
                adapter.submitList(it)
            }
        }

        b.fabAdd.setOnClickListener {
            startActivity(Intent(requireContext(), AddEditExpenseActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
    }
}
