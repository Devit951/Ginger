package devit951.github.ginger

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import devit951.github.ginger_bottombar.GingerBottomBarView
import devit951.github.ginger_ui.dpToPx
import devit951.github.ginger_ui.frameParams
import devit951.github.ginger_ui.matchParent

class SettingedGingerBottomBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    val gingerBottomBarView: GingerBottomBarView = GingerBottomBarView(context, attrs, defStyleAttr)
    val ivArrow: ImageView

    init {
        this@SettingedGingerBottomBarView.addView(
            ImageView(context).apply {
                val size = dpToPx(20)
                ivArrow = this
                rotation = -90f
                y = -size.toFloat() - dpToPx(8)
                setImageResource(R.drawable.ic_arrow)
                frameParams(width = matchParent, height = size)
            }
        )
        addView(gingerBottomBarView)
    }

}