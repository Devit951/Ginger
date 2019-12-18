package devit951.github.ginger_bottombar

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart

class GingerBottomBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var gingerItems = listOf<GingerItem>()
        set(value) {
            field = value
            fillItems()
        }

    val overlayView: View = View(context)

    private var itemWidth = 0
    private var lastSelectedGingerItemView: GingerItemView? = null
    private var animatorSet: AnimatorSet? = null

    init {
        overlayView.layoutParams = LayoutParams(0, 0)
        overlayView.background = ColorDrawable(Color.parseColor("#33FF0000"))
        addView(overlayView)
    }

    private fun fillItems() {
        addView(LinearLayout(context).apply {
            gingerItems.forEachIndexed { index, item ->
                addView(GingerItemView(context).apply {
                    layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT).apply {
                        weight = 1f
                    }
                    tag = "$index"
                    ivIcon.setImageResource(item.iconRes)
                    defaultIvIconColor = ivIcon.imageTintList
                    defaultTextColor = tvTitle.currentTextColor
                    tvTitle.setText(item.titleRes)
                    setOnClickListener {
                        if (lastSelectedGingerItemView?.tag != this.tag) {
                            animateOverlayPosition(index, this, item)
                        }
                    }
                })
            }
            (getChildAt(0) as GingerItemView).also {
                lastSelectedGingerItemView = it
            }.select()
            post {
                itemWidth = width / gingerItems.size
                overlayView.layoutParams = LayoutParams(itemWidth, height)
            }
        })
    }

    private fun animateOverlayPosition(
        index: Int,
        gingerItemView: GingerItemView,
        gingerItem: GingerItem
    ) {
        if (animatorSet == null || !animatorSet!!.isStarted) {
            animatorSet = AnimatorSet().also { animatorSet ->
                animatorSet.playSequentially(
                    overlayView.scaleValueAnim(1f, 0.1f),
                    ValueAnimator.ofFloat(overlayView.x, itemWidth.toFloat() * index).apply {
                        addUpdateListener {
                            overlayView.x = it.animatedValue as Float
                        }
                        doOnStart {
                            lastSelectedGingerItemView?.deselect()
                            lastSelectedGingerItemView = gingerItemView
                        }
                    },
                    overlayView.scaleValueAnim(0.1f, 1f).apply {
                        doOnEnd {
                            gingerItemView.select()
                            gingerItem.onClickListener.invoke()
                        }
                    })
                animatorSet.duration = 200
                animatorSet.start()
            }
        }
    }

    private fun View.scaleValueAnim(from: Float, to: Float): ValueAnimator {
        return ValueAnimator.ofFloat(from, to).also { valueAnimator ->
            valueAnimator.addUpdateListener {
                scaleX = it.animatedValue as Float
                scaleY = it.animatedValue as Float
            }
        }
    }
}