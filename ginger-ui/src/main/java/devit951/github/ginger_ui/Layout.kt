package devit951.github.ginger_ui

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout

fun Context.linearLayout(init: LinearLayout.() -> Unit) = LinearLayout(this).apply(init)
fun Context.verticalLayout(init: LinearLayout.() -> Unit) = linearLayout {
    orientation = LinearLayout.VERTICAL
    init(this)
}
fun Context.frameLayout(init: FrameLayout.() -> Unit) = FrameLayout(this).apply(init)

fun <T: ViewGroup> T.aFrameLayout(init: FrameLayout.() -> Unit) = apply {
    addView(context.frameLayout(init))
}

fun <T: ViewGroup> T.aLinearLayout(init: LinearLayout.() -> Unit) = apply {
    addView(context.linearLayout(init))
}

fun <T: ViewGroup> T.aVerticalLayout(init: LinearLayout.() -> Unit) = apply {
    addView(context.verticalLayout(init))
}

