package devit951.github.ginger.bottomtablist

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import devit951.github.ginger_ui.*

class BottomTabViewHolderUI: UI<LinearLayout> {

    lateinit var ivBottomTab: ImageView
    lateinit var tvBottomTab: TextView

    override fun create(context: Context) = fakeClickable(context.linearLayout {
        setPadding(dpToPx(8))
        ivBottomTab = imageView {}
        tvBottomTab = textView{}
    })
}