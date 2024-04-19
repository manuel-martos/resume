package info.degirona.mmartos.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@Immutable
data class UiSpecs(
    val topLeftIconScale: Float,
    val topLeftIconPadding: PaddingValues,
    val profilePictureSize: Dp,
    val profilePictureBorderWidth: Dp,
    val backgroundMaxColumns: Int,
)

expect fun getUiSpecs(): UiSpecs