package info.degirona.mmartos.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

actual fun getUiSpecs(): UiSpecs =
    UiSpecs(
        topLeftIconScale = 1.5f,
        topLeftIconPadding = PaddingValues(all = 32.dp),
        profilePictureSize = 64.dp,
        profilePictureBorderWidth = 4.dp,
        backgroundMaxColumns = 25,
    )