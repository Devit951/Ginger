package devit951.github.ginger.bottomtablist

import android.view.View
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import devit951.github.ginger.R
import devit951.github.ginger_ui.*
import java.util.*

class BottomTabListAdapter: RecyclerView.Adapter<BottomTabListAdapter.BottomTabViewHolder>(), BottomTabMoveCallback.Listener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomTabViewHolder {
        return BottomTabViewHolder(fakeClickable(parent.context.linearLayout {
            setPadding(dpToPx(8))
            imageView {
                setImageResource(R.drawable.ic_cat)
            }
            textView {
                setText("TEST")
            }
        }))
    }

    override fun getItemCount() = 3

    override fun onBindViewHolder(holder: BottomTabViewHolder, position: Int) {

    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
//        if (fromPosition < toPosition) {
//            for (i in fromPosition until toPosition) {
//                Collections.swap(users, i, i + 1)
//            }
//        } else {
//            for (i in fromPosition downTo toPosition + 1) {
//                Collections.swap(users, i, i - 1)
//            }
//        }
        notifyItemMoved(fromPosition, toPosition)
    }


    class BottomTabViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun render(){

        }
    }
}