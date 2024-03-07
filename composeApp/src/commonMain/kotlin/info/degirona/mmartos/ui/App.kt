package info.degirona.mmartos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import info.degirona.mmartos.modifiers.vignette
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import resume.composeapp.generated.resources.Res
import resume.composeapp.generated.resources.github_profile

@OptIn(ExperimentalResourceApi::class)
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
                    .vignette(100f, 0.3f, MaterialTheme.colorScheme.background)
                    .verticalScroll(rememberScrollState())
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
                                    20f * (firstPosition.x - halfWidth) / size.width.toFloat()
                                rotationValueX =
                                    20f * (firstPosition.y - halfHeight) / size.height.toFloat()
                            }
                        }
                    }
                    .padding(16.dp)
            ) {
                OutlinedCard(
                    onClick = {}
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = painterResource(Res.drawable.github_profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .border(
                                    1.dp,
                                    MaterialTheme.colorScheme.onPrimaryContainer,
                                    CircleShape
                                )
                        )
                        Text("Manel Martos", style = MaterialTheme.typography.headlineMedium)
                        Text("Lead Android Engineer", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}
