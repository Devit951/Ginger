package devit951.github.ginger_ui

import android.widget.FrameLayout
import android.widget.LinearLayout

fun LinearLayout.lparams(width: Int = wrapContent, height: Int = wrapContent, init: LinearLayout.LayoutParams.() -> Unit = {}) = apply {
    layoutParams = LinearLayout.LayoutParams(width, height).apply(init)
}
fun FrameLayout.lparams(width: Int = wrapContent, height: Int = wrapContent, init: FrameLayout.LayoutParams.() -> Unit = {}) = apply {
    layoutParams = FrameLayout.LayoutParams(width, height).apply(init)
}