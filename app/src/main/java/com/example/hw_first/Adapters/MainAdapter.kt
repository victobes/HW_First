package com.example.hw_first.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw_first.Activities.FilterActivity
import com.example.hw_first.Activities.MainActivity
import com.example.hw_first.Holders.ProjectInfoHolder
import com.example.hw_first.Holders.SkillHeaderHolder
import com.example.hw_first.Holders.SkillInfoHolder
import com.example.hw_first.Holders.StudentInfoHolder
import com.example.hw_first.Models.ProjectInfo
import com.example.hw_first.Models.SkillInfo
import com.example.hw_first.Models.StudentInfo
import com.example.hw_first.R
import kotlinx.android.synthetic.main.header_skills.view.*

class MainAdapter(private var items: List<Any>, private val filters: List<Boolean>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int): Int =
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
            2 -> (holder as SkillHeaderHolder).view.apply {

                if (filters.contains(false)) filter_image_button.setImageResource(R.drawable.filter_checked_icon)

                filter_image_button.setOnClickListener {
                    val intent = Intent(it.context, FilterActivity::class.java)
                    intent.putExtra(
                        "sendToFilter",
                        items
                            .slice(3 until items.count())
                            .map { item ->
                                (item as SkillInfo).studentExperience
                            }
                            .distinct()
                            .toFloatArray()
                    )

                    intent.putExtra(
                        "checkFilter",
                        filters.toBooleanArray()
                    )
                    (it.context as MainActivity).startActivityForResult(intent, 0)
                }
            }
            3 -> (holder as SkillInfoHolder).bind(items[position] as SkillInfo)
        }
    }

    override fun getItemCount(): Int =
        items.count()

    private val List<Any>.available
        get() = filterIndexed { index, _ ->
            (index < 3) or filters.run {
                if (this.isNotEmpty() and (index >= 3))
                    get(index - 3)
                else
                    true
            }
        }
}
