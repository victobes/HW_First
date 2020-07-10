package com.example.hw_first.Holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_first.Models.SkillInfo
import com.example.hw_first.Utils.timeConverter
import kotlinx.android.synthetic.main.skill_item.view.*

class SkillInfoHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var skillInfo: SkillInfo

    fun bind(skillInfo: SkillInfo) {
        view.apply {
            student_skill.text = skillInfo.studentSkill
            student_experience.text = timeConverter(skillInfo.studentExperience)
        }
        this.skillInfo = skillInfo
    }
}
