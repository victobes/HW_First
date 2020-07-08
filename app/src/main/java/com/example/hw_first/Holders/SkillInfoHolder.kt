package com.example.hw_first.Holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_first.Models.SkillInfo
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

    private fun timeConverter(experience: Double): String {
        val exp = experience.toInt()

        when {
            exp < 1 -> return "<1 года"
            (exp % 10 > 1) && (exp % 10 < 5) -> return "$exp года"
            ((exp % 10 == 1) && (exp != 11)) || (exp == 1) -> return "$exp год"
            else -> return "$exp лет"
        }
    }
}