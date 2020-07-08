package com.example.hw_first.Holders

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_first.Models.StudentInfo
import com.example.hw_first.R
import kotlinx.android.synthetic.main.header_student_info.view.*

class StudentInfoHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var studentInfo: StudentInfo

    fun bind(studentInfo: StudentInfo) {

        view.apply {

            student_name.text = studentInfo.studentName
            student_class.text = studentInfo.studentForm

            button.setOnClickListener {
                view.context.startActivity(
                    Intent(Intent.ACTION_VIEW, Uri.parse(studentInfo.studentGit))
                )
            }
        }

        this.studentInfo = studentInfo
    }
}