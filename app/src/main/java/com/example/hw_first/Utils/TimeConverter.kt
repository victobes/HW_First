package com.example.hw_first.Utils

fun timeConverter(experience: Float): String {
    val experience = experience.toInt()
    return when {
        experience < 1 -> "<1 года"
        (experience % 10 > 1) && (experience % 10 < 5) -> "$experience года"
        ((experience % 10 == 1) && (experience != 11)) || (experience == 1) -> "$experience год"
        else -> "$experience лет"
    }
}
