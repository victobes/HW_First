package com.example.hw_first.Holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_first.Models.ProjectInfo
import kotlinx.android.synthetic.main.project_info.view.*

class ProjectInfoHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var projectInfo: ProjectInfo

    fun bind(projectInfo: ProjectInfo) {
        view.apply {
            project_sub.text = projectInfo.projectSub
        }
        this.projectInfo = projectInfo
    }
}
