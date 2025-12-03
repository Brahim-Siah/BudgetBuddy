package com.example.budgetbuddy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetbuddy.data.Subscription
import com.example.budgetbuddy.databinding.SubscriptionItemBinding

class SubscriptionAdapter(
    private val onClick: (Subscription) -> Unit
) : ListAdapter<Subscription, SubscriptionAdapter.VH>(Diff) {

    object Diff : DiffUtil.ItemCallback<Subscription>() {
        override fun areItemsTheSame(old: Subscription, new: Subscription) = old.id == new.id
        override fun areContentsTheSame(old: Subscription, new: Subscription) = old == new
    }

    inner class VH(val b: SubscriptionItemBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = SubscriptionItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val s = getItem(position)
        holder.b.tvName.text = s.name
        holder.b.tvCost.text = "$${String.format("%.2f", s.monthlyCost)}/mo"
        holder.b.root.setOnClickListener { onClick(s) }
    }
}
