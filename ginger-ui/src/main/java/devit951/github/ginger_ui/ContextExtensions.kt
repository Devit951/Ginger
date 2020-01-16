package devit951.github.ginger_ui

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Context.color(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)
inline fun <reified T> Context.intent(params: Intent.() -> Unit = {}) = Intent(this, T::class.java).apply(params)
fun View.color(@ColorRes colorRes: Int) = context.color(colorRes)

fun <T: View> fakeClickable(target: T): T{
    return target.apply{
        isClickable = true
        isFocusable = true
        setBackgroundResource(context.obtainStyledAttributes(intArrayOf(R.attr.selectableItemBackground)).run {
            val res = getResourceId(0, 0)
            recycle()
            res
        })
    }
}

fun <T: View> clickable(target: T, onClickListener: ((View) -> Unit)): T{
    return target.apply{
        fakeClickable(target)
        setOnClickListener(onClickListener)
    }
}

fun dpToPx(dp: Int) = dp * Resources.getSystem().displayMetrics.density.toInt()