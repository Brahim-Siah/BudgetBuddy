package com.example.budgetbuddy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetbuddy.data.Expense
import com.example.budgetbuddy.databinding.ItemExpenseBinding
import com.example.budgetbuddy.util.DateUtils

class ExpenseAdapter(
    private val onClick: (Expense) -> Unit
) : ListAdapter<Expense, ExpenseAdapter.VH>(Diff) {

    object Diff : DiffUtil.ItemCallback<Expense>() {
        override fun areItemsTheSame(old: Expense, new: Expense) = old.id == new.id
        override fun areContentsTheSame(old: Expense, new: Expense) = old == new
    }

    inner class VH(val b: ItemExpenseBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemExpenseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val e = getItem(position)
        holder.b.tvAmount.text = "$" + String.format("%.2f", e.amountUsd)
        holder.b.tvCategory.text = e.category
        holder.b.tvDate.text = DateUtils.formatDate(e.date)
        holder.b.root.setOnClickListener { onClick(e) }
    }
}
