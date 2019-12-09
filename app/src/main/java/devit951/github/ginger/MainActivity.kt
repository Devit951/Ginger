package devit951.github.ginger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import devit951.github.ginger_bottombar.GingerBottomBarView
import devit951.github.ginger_bottombar.GingerItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(FrameLayout(this).apply {
            layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            addView(GingerBottomBarView(context).apply {
                layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
                    gravity = Gravity.BOTTOM
                }
                overlayView.setBackgroundColor(resources.getColor(R.color.colorPrimary))
                gingerItems = listOf(
                    GingerItem(android.R.drawable.ic_delete, android.R.string.cancel),
                    GingerItem(android.R.drawable.ic_dialog_alert, android.R.string.copyUrl),
                    GingerItem(android.R.drawable.ic_input_add, android.R.string.cut)
                )
            })
        })
    }
}
