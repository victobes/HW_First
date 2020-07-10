package com.example.hw_first.Holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_first.Models.SkillFilter

class SkillFilterHolder(val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var skillFilter: SkillFilter

    fun bind(skillFilter: SkillFilter) {
        this.skillFilter = skillFilter
    }
}
