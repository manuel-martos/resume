package info.degirona.mmartos.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

actual fun getUiSpecs(): UiSpecs =
    UiSpecs(
        topLeftIconScale = 1f,
        topLeftIconPadding = PaddingValues(start = 8.dp, top = 48.dp),
        profilePictureSize = 64.dp,
        profilePictureBorderWidth = 2.dp,
        backgroundMaxColumns = 10,
    )