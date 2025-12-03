package com.example.budgetbuddy.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetbuddy.data.AppDatabase
import com.example.budgetbuddy.databinding.FragmentDashboardBinding
import com.example.budgetbuddy.ui.adapter.ExpenseAdapter
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private lateinit var recentAdapter: ExpenseAdapter

    private var _b: FragmentDashboardBinding? = null
    private val b get() = _b!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _b = FragmentDashboardBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val dao = AppDatabase.getDatabase(requireContext()).expenseDao()

        // ---------------------------
        // 1) SETUP RECENT EXPENSES LIST
        // ---------------------------
        recentAdapter = ExpenseAdapter { /* open detail later if you want */ }
        b.rvRecent.layoutManager = LinearLayoutManager(requireContext())
        b.rvRecent.adapter = recentAdapter


        // ---------------------------
        // 2) TOTAL SPENDING
        // ---------------------------
        viewLifecycleOwner.lifecycleScope.launch {
            dao.getTotalSpending().collectLatest { total ->
                b.tvTotal.text = "$" + String.format("%.2f", total ?: 0.0)
            }
        }


        // ---------------------------
        // 3) PIE CHART + RECENT LIST
        // ---------------------------
        viewLifecycleOwner.lifecycleScope.launch {
            dao.getAllExpenses().collectLatest { list ->

                // ---- Update recent list (last 5 expenses) ----
                recentAdapter.submitList(
                    list.sortedByDescending { it.date }.take(5)
                )

                // ---- Group for PieChart ----
                val grouped = list.groupBy { it.category }
                    .mapValues { it.value.sumOf { e -> e.amountUsd } }

                val entries = grouped.map { PieEntry(it.value.toFloat(), it.key) }

                val dataSet = PieDataSet(entries, "")

                dataSet.colors = listOf(
                    Color.rgb(244, 67, 54),
                    Color.rgb(33, 150, 243),
                    Color.rgb(255, 193, 7),
                    Color.rgb(0, 150, 136),
                    Color.rgb(156, 39, 176),
                    Color.rgb(76, 175, 80)
                )

                dataSet.setDrawValues(false)

                val pieData = PieData(dataSet)
                b.pieChart.data = pieData

                // Label + Style
                b.pieChart.setEntryLabelColor(Color.BLACK)
                b.pieChart.setEntryLabelTextSize(14f)
                b.pieChart.centerText = "Spending\nby Category"
                b.pieChart.setCenterTextSize(16f)
                b.pieChart.setCenterTextColor(Color.BLACK)
                b.pieChart.setHoleColor(Color.WHITE)
                b.pieChart.setTransparentCircleColor(Color.WHITE)

                // Legend
                val legend = b.pieChart.legend
                legend.textSize = 14f
                legend.textColor = Color.BLACK
                legend.orientation = Legend.LegendOrientation.HORIZONTAL
                legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
                legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
                legend.isWordWrapEnabled = true

                b.pieChart.animateY(1200)
                b.pieChart.invalidate()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
    }
}
