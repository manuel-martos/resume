package info.degirona.mmartos

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import info.degirona.mmartos.ui.App

fun MainViewController() = ComposeUIViewController {
    App(modifier = Modifier.fillMaxSize())
}