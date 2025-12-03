package com.example.budgetbuddy.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.budgetbuddy.data.AppDatabase
import com.example.budgetbuddy.databinding.FragmentSubscriptionsBinding
import com.example.budgetbuddy.ui.adapter.SubscriptionAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SubscriptionsFragment : Fragment() {

    private var _b: FragmentSubscriptionsBinding? = null
    private val b get() = _b!!
    private lateinit var adapter: SubscriptionAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _b = FragmentSubscriptionsBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = SubscriptionAdapter { sub ->
            val i = Intent(requireContext(), AddEditSubscriptionActivity::class.java)
            i.putExtra("subscriptionId", sub.id)
            startActivity(i)
        }

        b.rvSubscriptions.layoutManager = GridLayoutManager(requireContext(), 2)
        b.rvSubscriptions.adapter = adapter

        val dao = AppDatabase.getDatabase(requireContext()).subscriptionDao()

        viewLifecycleOwner.lifecycleScope.launch {
            dao.getAllSubscriptions().collectLatest {
                adapter.submitList(it)
            }
        }

        b.fabAdd.setOnClickListener {
            startActivity(Intent(requireContext(), AddEditSubscriptionActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
    }
}
