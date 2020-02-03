package devit951.github.ginger.bottomtablist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import devit951.github.ginger_bottombar.GingerItem
import java.util.*

class BottomTabListAdapter(private val gingerItemList: List<GingerItem>): RecyclerView.Adapter<BottomTabListAdapter.BottomTabViewHolder>(), BottomTabMoveCallback.Listener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomTabViewHolder {
        return BottomTabViewHolder(BottomTabViewHolderUI(), parent.context)
    }

    override fun getItemCount() = gingerItemList.size

    override fun onBindViewHolder(holder: BottomTabViewHolder, position: Int) {
        holder.render(gingerItemList[position])
    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(gingerItemList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(gingerItemList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    class BottomTabViewHolder(private val bottomTabViewHolderUI: BottomTabViewHolderUI, context: Context) : RecyclerView.ViewHolder(bottomTabViewHolderUI.create(context)){
        fun render(gingerItem: GingerItem){
            bottomTabViewHolderUI.ivBottomTab.setImageResource(gingerItem.iconRes)
            bottomTabViewHolderUI.tvBottomTab.setText(gingerItem.titleRes)
        }
    }
}