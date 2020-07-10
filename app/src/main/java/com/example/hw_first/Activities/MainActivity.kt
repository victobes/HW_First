package com.example.hw_first.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_first.Adapters.MainAdapter
import com.example.hw_first.Models.ProjectInfo
import com.example.hw_first.Models.SkillFilter
import com.example.hw_first.Models.SkillInfo
import com.example.hw_first.Models.StudentInfo
import com.example.hw_first.R
import com.example.hw_first.Utils.RVItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var studentSkills = listOf(
        SkillInfo("Kotlin", 0.2f),
        SkillInfo("Java", 1f),
        SkillInfo("Pascal", 2f)
    )

    private var filters = studentSkills.map { it.studentExperience.toInt() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "О себе"

        main_recycler.layoutManager = LinearLayoutManager(this)

        loadMainAdapter()

        main_recycler.addItemDecoration(
            RVItemDecorator(
                20
            )
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        filters = data?.getIntArrayExtra("filter")!!.toList()
        Log.d("lol", filters.toString())
        loadMainAdapter()

        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putIntArray("filter", filters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        filters = savedInstanceState.getIntArray("filter")!!.asList()
        loadMainAdapter()
    }

    private fun loadMainAdapter() {

        var filtredStudentSkills = studentSkills.map { (it.studentExperience.toInt() in filters) }
        Log.d("dumpling", filtredStudentSkills.toString())

        val adapter =
            MainAdapter(
                listOf(
                    StudentInfo("Беспалова Виктория", "9 класс", "https://github.com/victobes"),
                    ProjectInfo("Спойлер: у нашей команды уже появилась идея проекта.\n" + "Что касается моей изначальной идеи, то я хотела сделать приложение про города \"Золотого кольца\", чтобы поддержать внутренний туризм, так как сейчас все границы закрыты, а люди хотят увидеть что-то новое и сменить атмосферу после удаленки.\n" + "Идея, которая родилась в ходе обсуждения с командой: сделать приложение с маршрутами для электротранспорта (возможность прокладывать маршруты по городу, избегать разбитых дорог, составлять кастомные маршруты). Сейчас популярность электротранспорта набирает обороты, поэтому достаточно актуально."),
                    SkillFilter()
                ) + studentSkills,
                filtredStudentSkills
            )

        main_recycler.adapter = adapter
    }
}
