package dk.shape.forecast.utils.ui

import android.content.Context
import android.content.res.ColorStateList

fun Int.colorResourceToStateList(context: Context): ColorStateList {
    val color = context.resources.getColor(this)
    val states = array2dOfInt(1, 1)
    val colors = intArrayOf(color)
    return ColorStateList(states, colors)
}

private fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray> = Array(sizeOuter) { IntArray(sizeInner) }