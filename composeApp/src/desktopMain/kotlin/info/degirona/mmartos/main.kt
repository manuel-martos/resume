package info.degirona.mmartos

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import info.degirona.mmartos.ui.App

fun main() = application {
    val windowState = rememberWindowState(size = DpSize(1920.dp, 1080.dp), position = WindowPosition.Absolute(0.dp, 0.dp))
    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = "Manel Martos - Resume",
        undecorated = true,
        transparent = true,
    ) {
        WindowDraggableArea(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
        ) {
            App(modifier = Modifier.fillMaxSize())
        }
    }
}

@Preview
@Composable
fun Preview() {
    App(modifier = Modifier.fillMaxSize())
}