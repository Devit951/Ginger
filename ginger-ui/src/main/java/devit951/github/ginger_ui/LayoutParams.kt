package devit951.github.ginger_ui

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout

fun <T: View> T.linearParams(width: Int = wrapContent, height: Int = wrapContent, init: LinearLayout.LayoutParams.() -> Unit = {}) = apply {
    lparams(LinearLayout.LayoutParams(width, height).apply(init))
}

fun <T: View> T.frameParams(width: Int = wrapContent, height: Int = wrapContent, init: FrameLayout.LayoutParams.() -> Unit = {}) = apply {
    lparams(FrameLayout.LayoutParams(width, height).apply(init))
}

fun <T: View, P: ViewGroup.LayoutParams> T.lparams(params: P): T{
    layoutParams = params
    return this
}
