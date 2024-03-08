package info.degirona.mmartos.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import info.degirona.mmartos.modifiers.vignette
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.max
import kotlin.math.min

@Composable
@Preview
fun App() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            var rotationValueX by remember { mutableFloatStateOf(0f) }
            var rotationValueY by remember { mutableFloatStateOf(0f) }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .vignette(255f, 2.5f, MaterialTheme.colorScheme.background)
                    .graphicsLayer {
                        this.rotationX = rotationValueX
                        this.rotationY = rotationValueY
                    }
                    .pointerInput(Unit) {
                        while (true) {
                            this.awaitPointerEventScope {
                                val event = this.awaitPointerEvent()
                                val firstPosition = event.changes.first().position
                                val halfWidth = size.width / 2f
                                val halfHeight = size.height / 2f
                                rotationValueY =
                                    max(-10f, min(10f * (firstPosition.x - halfWidth) / size.width.toFloat(), 10f))
                                rotationValueX =
                                    max(-10f, min(10f * (firstPosition.y - halfHeight) / size.height.toFloat(), 10f))
                            }
                        }
                    }
                    .padding(16.dp)
            ) {
                Content(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
