package info.degirona.mmartos.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

// Snippet caught on KotlinLang Slack:
//  https://kotlinlang.slack.com/archives/C01F2HV7868/p1704177387127039?thread_ts=1704144725.524759&cid=C01F2HV7868
private val isMobile: Boolean
    get() {
        val mobileKeywords = setOf("Mobile", "Android", "iPhone", "iPad", "iPod", "Windows Phone")
        return mobileKeywords.any { keyword -> window.navigator.userAgent.contains(keyword) }
    }

actual fun getUiSpecs(): UiSpecs =
    if (isMobile) {
        UiSpecs(
            topLeftIconScale = 1f,
            topLeftIconPadding = PaddingValues(all = 8.dp),
            profilePictureSize = 32.dp,
            profilePictureBorderWidth = 2.dp,
            backgroundMaxColumns = 10,
        )
    } else {
        UiSpecs(
            topLeftIconScale = 1.5f,
            topLeftIconPadding = PaddingValues(all = 32.dp),
            profilePictureSize = 64.dp,
            profilePictureBorderWidth = 4.dp,
            backgroundMaxColumns = 25,
        )
    }

