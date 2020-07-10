package com.example.hw_first.Models

import com.example.hw_first.Utils.timeConverter

class Filter(
    var experience: Float,
    var state: Boolean = true
) {
    val text get() = timeConverter(experience)
}
