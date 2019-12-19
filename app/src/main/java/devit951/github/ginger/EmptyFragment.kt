package devit951.github.ginger

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import devit951.github.ginger_ui.arg
import devit951.github.ginger_ui.frameLayout
import devit951.github.ginger_ui.frameParams
import devit951.github.ginger_ui.textView

class EmptyFragment @JvmOverloads constructor(bgColor: Int = Color.RED) : Fragment() {

    companion object {
        private const val ARG_COLOR = "ARG_COLOR"
    }

    init {
        arguments = bundleOf(ARG_COLOR to bgColor)
    }

    private val color by arg<Int>(ARG_COLOR)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = frameLayout {
        setBackgroundColor(color)
        textView {
            text = "TESTT"
            setTextColor(Color.WHITE)
        }.frameParams {
            gravity = Gravity.CENTER
        }
    }
}