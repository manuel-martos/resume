package info.degirona.mmartos

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.CanvasBasedWindow
import info.degirona.mmartos.ui.App
import kotlinx.browser.document
import org.w3c.dom.get

external fun onWasmReady(onReady: () -> Unit)

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow(canvasElementId = "ComposeTarget") {
            App(modifier = Modifier.fillMaxSize())
            removeLoader()
        }
    }
}

private fun removeLoader() {
    val loader = document.getElementsByClassName("loader")[0]
    loader?.parentNode?.removeChild(loader)
}