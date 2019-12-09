package devit951.github.ginger_bottombar

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding

class GingerItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr)  {

    val ivIcon: ImageView
    val tvTitle: TextView

    var defaultIvIconColor: ColorStateList? = null
    var defaultTextColor: Int = 0


    init {
        orientation = VERTICAL
        setPadding(16)
        addView(ImageView(context).apply {
            ivIcon = this
            gravity = Gravity.CENTER
        })
        addView(TextView(context).apply {
            tvTitle = this
            gravity = Gravity.CENTER
        })
    }

    fun select(){
        scaleX = 1.15f
        scaleY = 1.15f
        ivIcon.imageTintList = ColorStateList.valueOf(Color.WHITE)
        tvTitle.setTextColor(Color.WHITE)
    }

    fun deselect(){
        scaleX = 1f
        scaleY = 1f
        ivIcon.imageTintList = defaultIvIconColor
        tvTitle.setTextColor(defaultTextColor)
    }
}