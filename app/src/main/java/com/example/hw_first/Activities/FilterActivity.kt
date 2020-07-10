package com.example.hw_first.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_first.Adapters.FilterAdapter
import com.example.hw_first.Models.Filter
import com.example.hw_first.R
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {

    private var filter = emptyList<Int>()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBooleanArray(
            "SAVED_SELECTION",
            (filter_recycler.adapter as FilterAdapter)
                .filters.map { it.state }.toBooleanArray()
        )
        outState.putIntArray(
            "nowFilter",
            filter.toIntArray()
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val sendToFilter = intent.getFloatArrayExtra("sendToFilter")!!

        var savedSelection = savedInstanceState.getBooleanArray("SAVED_SELECTION")
        if (savedSelection == null)
            savedSelection = List(sendToFilter.size) { true }.toBooleanArray()

        filter = savedInstanceState.getIntArray("nowFilter")!!.toList()

        val adapter =
            FilterAdapter(
                sendToFilter
                    .mapIndexed { index, fl ->
                        Filter(fl, savedSelection[index])
                    }
            )

        filter_recycler.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val toFilter = intent.getFloatArrayExtra("sendToFilter")!!
        val nowFilter = intent.getBooleanArrayExtra("nowFilter")!!
        filter = toFilter.filterIndexed { index, _ -> nowFilter[index] }.map { it.toInt() }

        val adapter =
            FilterAdapter(
                toFilter
                    .mapIndexed { index, item ->
                        Filter(item, state = nowFilter[index])
                    }
            )

        filter_recycler.layoutManager = LinearLayoutManager(this)

        filter_recycler.adapter = adapter
    }

    override fun onStart() {
        checkbox_all.setOnCheckedChangeListener { _, b ->
            val adapter =
                FilterAdapter(
                    (filter_recycler.adapter as FilterAdapter).filters
                        .map { item ->
                            Filter(item.experience, state = b)
                        }
                )

            filter_recycler.adapter = adapter
        }

        super.onStart()
    }

    @Suppress("UNUSED_PARAMETER")
    fun onFiltersChosen(view: View) {
        sendResult(
            (filter_recycler.adapter as FilterAdapter)
                .filters.filter { it.state }.map { it.experience.toInt() }.toIntArray()
        )
        Log.d("kek", filter.size.toString())
    }

    override fun onBackPressed() {
        sendResult(filter.toIntArray())
    }

    private fun sendResult(result: IntArray) {
        val answerIntent = Intent()

        answerIntent.putExtra(
            "filter",
            result
        )

        setResult(0, answerIntent)
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
