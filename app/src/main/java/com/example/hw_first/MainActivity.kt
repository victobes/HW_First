package com.example.hw_first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_first.Models.ProjectInfo
import com.example.hw_first.Models.SkillInfo
import com.example.hw_first.Models.StudentInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "О себе"

        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = Adapter(
            listOf(
                StudentInfo("Беспалова Виктория", "9 класс", "https://github.com/victobes"),
                ProjectInfo("Ули́тки — общеупотребительное название брюхоногих моллюсков (лат. Gastropoda), обладающих наружной раковиной. Брюхоногих моллюсков с рудиментарной раковиной или полностью утративших её называют слизнями. Поскольку большинство брюхоногих обладает раковиной, улитками часто называют всех представителей класса."),
                Any(),
                SkillInfo("Java", 1.0),
                SkillInfo("Kotlin", 0.2)
            )
        )

        recycler.adapter = adapter
        recycler.addItemDecoration(RVItemDecorator(20))
    }
}