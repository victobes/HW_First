package com.example.hw_first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw_first.Holders.ProjectInfoHolder
import com.example.hw_first.Holders.SkillHeaderHolder
import com.example.hw_first.Holders.SkillInfoHolder
import com.example.hw_first.Holders.StudentInfoHolder
import com.example.hw_first.Models.ProjectInfo
import com.example.hw_first.Models.SkillInfo
import com.example.hw_first.Models.StudentInfo

class Adapter(private var items: List<Any>) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int) =
        when (position) {
            0 -> 0
            1 -> 1
            2 -> 2
            else -> 3
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> StudentInfoHolder(inflater.inflate(R.layout.header_student_info, parent, false))
            1 -> ProjectInfoHolder(inflater.inflate(R.layout.project_info, parent, false))
            2 -> SkillHeaderHolder(inflater.inflate(R.layout.header_skills, parent, false))
            3 -> SkillInfoHolder(inflater.inflate(R.layout.skill_item, parent, false))
            else -> throw Exception("ViewType not found")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> (holder as StudentInfoHolder).bind(items[position] as StudentInfo)
            1 -> (holder as ProjectInfoHolder).bind(items[position] as ProjectInfo)
            3 -> (holder as SkillInfoHolder).bind(items[position] as SkillInfo)
        }
    }

    override fun getItemCount(): Int =
        items.count()

}
