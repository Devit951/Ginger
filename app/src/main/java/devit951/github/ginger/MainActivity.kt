package devit951.github.ginger

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import devit951.github.ginger_bottombar.GingerBottomBarView
import devit951.github.ginger_bottombar.GingerItem
import devit951.github.ginger_ui.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ID_MAIN_ROOT_FRAGMENT = 23
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(frameLayout {
            aVerticalLayout {
                aFrameLayout {
                    id = ID_MAIN_ROOT_FRAGMENT
                    linearParams(width = matchParent, height = 0) {
                        weight = 1f
                    }
                }
                addView(GingerBottomBarView(context).apply {
                    overlayView.setBackgroundColor(color(R.color.colorPrimary))
                    gingerItems = listOf(
                        GingerItem(
                            android.R.drawable.ic_delete,
                            android.R.string.cancel,
                            onClickListener = {
                                autoHideShowFragment(savedFragment(ID_MAIN_ROOT_FRAGMENT, "1") {
                                    EmptyFragment(Color.GREEN)
                                })
                            }),
                        GingerItem(
                            android.R.drawable.ic_dialog_alert,
                            android.R.string.copyUrl,
                            onClickListener = {
                                autoHideShowFragment(savedFragment(ID_MAIN_ROOT_FRAGMENT, "2") {
                                    EmptyFragment(Color.RED)
                                })
                            }),
                        GingerItem(
                            android.R.drawable.ic_input_add,
                            android.R.string.cut,
                            onClickListener = {
                                autoHideShowFragment(savedFragment(ID_MAIN_ROOT_FRAGMENT, "3") {
                                    EmptyFragment(Color.BLUE)
                                })
                            })
                    )
                    linearParams(width = matchParent)
                })
            }
            frameParams(width = matchParent, height = matchParent)
        })
        if (savedInstanceState == null) {
            autoHideShowFragment(savedFragment(ID_MAIN_ROOT_FRAGMENT, "1") {
                EmptyFragment(Color.GREEN)
            })
        }
    }
}
