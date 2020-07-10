package com.example.hw_first.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_first.Holders.FilterHolder
import com.example.hw_first.Models.Filter
import com.example.hw_first.R

class FilterAdapter(var filters: List<Filter>) : RecyclerView.Adapter<FilterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FilterHolder(
            inflater.inflate(R.layout.filter_item, parent, false) as CheckBox
        )
    }

    override fun onBindViewHolder(holder: FilterHolder, position: Int) {
        val filterItem = filters[position]

        holder.apply {
            view.text = filterItem.text
            view.isChecked = filterItem.state

            view.setOnCheckedChangeListener { _, b ->
                filters[position].state = b
            }
        }
    }

    override fun getItemCount(): Int =
        filters.count()
}
