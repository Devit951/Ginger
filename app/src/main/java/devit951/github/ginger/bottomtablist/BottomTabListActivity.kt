package devit951.github.ginger.bottomtablist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import devit951.github.ginger_ui.frameLayout
import devit951.github.ginger_ui.frameParams
import devit951.github.ginger_ui.matchParent
import devit951.github.ginger_ui.recyclerView

class BottomTabListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            frameLayout {
                recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    adapter = BottomTabListAdapter().also { bottomTabAdapter ->
                        ItemTouchHelper(BottomTabMoveCallback(bottomTabAdapter)).attachToRecyclerView(this)
                    }
                }
            }.frameParams(width = matchParent)
        )
    }
}