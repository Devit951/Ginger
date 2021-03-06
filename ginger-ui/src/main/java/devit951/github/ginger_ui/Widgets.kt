package devit951.github.ginger_ui

import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

fun <T: ViewGroup> T.textView(init: TextView.() -> Unit) = TextView(context).apply{
    init(this)
    addView(this)
}

fun <T: ViewGroup> T.imageView(init: ImageView.() -> Unit) = ImageView(context).apply{
    init(this)
    addView(this)
}

fun <T: ViewGroup> T.button(init: Button.() -> Unit) = Button(context).apply{
    init(this)
    addView(this)
}

fun <T: ViewGroup> T.recyclerView(init: RecyclerView.() -> Unit) = RecyclerView(context).also{
    init(it)
    addView(it)
}