package devit951.github.ginger

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import devit951.github.ginger.bottomtablist.BottomTabListActivity
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
                clipChildren = false
                aFrameLayout {
                    id = ID_MAIN_ROOT_FRAGMENT
                    clickable(
                        imageView {
                            setImageResource(R.drawable.ic_arrow)
                            frameParams(width = matchParent, height = dpToPx(25)) {
                                gravity = Gravity.BOTTOM or Gravity.CENTER
                            }
                        }
                    ){
                        startActivity(intent<BottomTabListActivity>())
                    }
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
                                autoHideShowFragment(ID_MAIN_ROOT_FRAGMENT, "First") {
                                    JokeFragment()
                                }
                            }),
                        GingerItem(
                            R.drawable.ic_cat,
                            R.string.random_cat,
                            onClickListener = {
                                autoHideShowFragment(ID_MAIN_ROOT_FRAGMENT, "Second"){
                                    RandomCatImageFragment()
                                }
                            }),
                        GingerItem(
                            R.drawable.ic_dog,
                            R.string.random_dog,
                            onClickListener = {
                                autoHideShowFragment(ID_MAIN_ROOT_FRAGMENT, "Third") {
                                    RandomDogFragment()
                                }
                            })
                    )
                    linearParams(width = matchParent)
                })
            }
            frameParams(width = matchParent, height = matchParent)
        })
        autoHideShowFragment(ID_MAIN_ROOT_FRAGMENT, "First") {
            JokeFragment()
        }
    }
}
