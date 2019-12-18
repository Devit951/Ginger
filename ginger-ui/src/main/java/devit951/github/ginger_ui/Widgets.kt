package devit951.github.ginger_ui

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

fun <T: ViewGroup> T.textView(init: TextView.() -> Unit) = TextView(context).apply{
    init(this)
    addView(this)
}

fun <T: ViewGroup> T.imageView(init: ImageView.() -> Unit) = ImageView(context).apply{
    init(this)
    addView(this)
}