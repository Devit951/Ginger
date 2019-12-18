package devit951.github.ginger_bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class GingerItem(
    @DrawableRes val iconRes: Int,
    @StringRes val titleRes: Int,
    val onClickListener: () -> Unit
)