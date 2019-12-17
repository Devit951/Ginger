package devit951.github.ginger_ui

import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Context.color(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)
fun View.color(@ColorRes colorRes: Int) = context.color(colorRes)