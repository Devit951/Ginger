package devit951.github.ginger

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import devit951.github.ginger.jokes.JokeFragment
import devit951.github.ginger.randomcatimage.RandomCatImageFragment
import devit951.github.ginger.randomdog.RandomDogFragment
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
                            R.drawable.ic_joke,
                            R.string.jokes,
                            onClickListener = {
                                autoHideShowFragment(savedFragment(ID_MAIN_ROOT_FRAGMENT, "1") {
                                    JokeFragment()
                                })
                            }),
                        GingerItem(
                            R.drawable.ic_cat,
                            R.string.random_cat,
                            onClickListener = {
                                autoHideShowFragment(savedFragment(ID_MAIN_ROOT_FRAGMENT, "2") {
                                    RandomCatImageFragment()
                                })
                            }),
                        GingerItem(
                            R.drawable.ic_dog,
                            R.string.random_dog,
                            onClickListener = {
                                autoHideShowFragment(savedFragment(ID_MAIN_ROOT_FRAGMENT, "3") {
                                    RandomDogFragment()
                                })
                            })
                    )
                    linearParams(width = matchParent)
                })
            }
            frameParams(width = matchParent, height = matchParent)
        })
        autoHideShowFragment(savedFragment(ID_MAIN_ROOT_FRAGMENT, "1") {
            JokeFragment()
        })
    }
}
