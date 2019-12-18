package devit951.github.ginger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                    linearParams(width = matchParent, height = 0){
                        weight = 1f
                    }
                }
                addView(GingerBottomBarView(context).apply {
                    overlayView.setBackgroundColor(color(R.color.colorPrimary))
                    gingerItems = listOf(
                        GingerItem(android.R.drawable.ic_delete, android.R.string.cancel, onClickListener = {

                        }),
                        GingerItem(android.R.drawable.ic_dialog_alert, android.R.string.copyUrl, onClickListener = {

                        }),
                        GingerItem(android.R.drawable.ic_input_add, android.R.string.cut, onClickListener = {
                            replaceFragment(ID_MAIN_ROOT_FRAGMENT, EmptyFragment())
                        })
                    )
                    linearParams(width = matchParent)
                })
            }
            frameParams(width = matchParent, height = matchParent)
        })
    }
}
