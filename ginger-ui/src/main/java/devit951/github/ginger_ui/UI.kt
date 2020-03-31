package devit951.github.ginger_ui

import android.content.Context
import android.view.View

interface UI<ROOTVIEW: View> {
    fun create(context: Context): ROOTVIEW
}