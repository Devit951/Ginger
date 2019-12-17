package devit951.github.ginger_ui

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout

fun Context.linearLayout(init: LinearLayout.() -> Unit) = LinearLayout(this).apply(init)
fun Context.verticalLayout(init: LinearLayout.() -> Unit) = linearLayout {
    orientation = LinearLayout.VERTICAL
}
fun Context.frameLayout(init: FrameLayout.() -> Unit) = FrameLayout(this).apply(init)

fun ViewGroup.aFrameLayout(init: FrameLayout.() -> Unit) = context.frameLayout{
    init(this)
    addView(this)
}

fun ViewGroup.aLinearLayout(init: LinearLayout.() -> Unit) = context.linearLayout{
    init(this)
    addView(this)
}

fun ViewGroup.aVerticalLayout(init: LinearLayout.() -> Unit) = context.verticalLayout{
    init(this)
    addView(this)
}

