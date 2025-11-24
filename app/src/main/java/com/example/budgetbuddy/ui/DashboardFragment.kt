package com.example.budgetbuddy.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.budgetbuddy.data.AppDatabase
import com.example.budgetbuddy.databinding.FragmentDashboardBinding
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _b: FragmentDashboardBinding? = null
    private val b get() = _b!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _b = FragmentDashboardBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dao = AppDatabase.getDatabase(requireContext()).expenseDao()

        // ---- TOTAL SPENDING ----
        viewLifecycleOwner.lifecycleScope.launch {
            dao.getTotalSpending().collectLatest { total ->
                b.tvTotal.text = "$" + String.format("%.2f", total ?: 0.0)
            }
        }

        // ---- PIE CHART ----
        viewLifecycleOwner.lifecycleScope.launch {
            dao.getAllExpenses().collectLatest { list ->

                val grouped = list.groupBy { it.category }
                    .mapValues { it.value.sumOf { e -> e.amountUsd } }

                val entries = grouped.map { PieEntry(it.value.toFloat(), it.key) }

                val dataSet = PieDataSet(entries, "")

                // 🎨 >>> BEAUTIFUL CATEGORY COLORS <<<
                dataSet.colors = listOf(
                    Color.rgb(244, 67, 54),     // Red
                    Color.rgb(33, 150, 243),    // Blue
                    Color.rgb(255, 193, 7),     // Amber
                    Color.rgb(0, 150, 136),     // Teal
                    Color.rgb(156, 39, 176),    // Purple
                    Color.rgb(76, 175, 80),     // Green
                )

                // Hide values on slices, looks cleaner
                dataSet.setDrawValues(false)

                val pieData = PieData(dataSet)
                b.pieChart.data = pieData

                // 📌 Label styling
                b.pieChart.setEntryLabelColor(Color.BLACK)
                b.pieChart.setEntryLabelTextSize(14f)

                // 📌 Center text
                b.pieChart.centerText = "Spending\nby Category"
                b.pieChart.setCenterTextSize(16f)
                b.pieChart.setCenterTextColor(Color.BLACK)

                // 📌 Hole styling
                b.pieChart.setHoleColor(Color.WHITE)
                b.pieChart.setTransparentCircleColor(Color.WHITE)

                // 📌 Legend styling
                val legend = b.pieChart.legend
                legend.textSize = 14f
                legend.textColor = Color.BLACK
                legend.orientation = Legend.LegendOrientation.HORIZONTAL
                legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
                legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
                legend.isWordWrapEnabled = true

                // 📌 Animation
                b.pieChart.animateY(1200)

                // Refresh
                b.pieChart.invalidate()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
    }
}
