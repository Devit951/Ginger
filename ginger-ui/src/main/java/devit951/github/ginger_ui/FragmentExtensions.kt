package devit951.github.ginger_ui

import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

fun Fragment.linearLayout(init: LinearLayout.() -> Unit) = requireContext().linearLayout(init)
fun Fragment.verticalLayout(init: LinearLayout.() -> Unit) = requireContext().verticalLayout(init)
fun Fragment.frameLayout(init: FrameLayout.() -> Unit) = requireContext().frameLayout(init)


@Suppress("UNCHECKED_CAST")
fun <T> Fragment.arg(key: String) = lazy(mode = LazyThreadSafetyMode.NONE){
    arguments?.get(key) as T
}
