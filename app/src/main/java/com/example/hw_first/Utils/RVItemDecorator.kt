package com.example.hw_first.Utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RVItemDecorator : RecyclerView.ItemDecoration {
    private var verticalDistance: Int

    constructor(verticalDistance: Int) : super() {
        this.verticalDistance = verticalDistance
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = verticalDistance
    }
}
