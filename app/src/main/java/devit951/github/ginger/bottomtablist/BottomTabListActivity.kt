package devit951.github.ginger.bottomtablist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import devit951.github.ginger.MainActivity
import devit951.github.ginger.R
import devit951.github.ginger.jokes.JokeFragment
import devit951.github.ginger.randomcatimage.RandomCatImageFragment
import devit951.github.ginger.randomdog.RandomDogFragment
import devit951.github.ginger_bottombar.GingerItem
import devit951.github.ginger_ui.*

class BottomTabListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            frameLayout {
                recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    adapter = BottomTabListAdapter(listOf(
                        GingerItem(
                            R.drawable.ic_joke,
                            R.string.jokes,
                            onClickListener = {}),
                        GingerItem(
                            R.drawable.ic_cat,
                            R.string.random_cat,
                            onClickListener = {}),
                        GingerItem(
                            R.drawable.ic_dog,
                            R.string.random_dog,
                            onClickListener = {})
                    )).also { bottomTabAdapter ->
                        ItemTouchHelper(BottomTabMoveCallback(bottomTabAdapter)).attachToRecyclerView(this)
                    }
                }
            }.frameParams(width = matchParent)
        )
    }
}