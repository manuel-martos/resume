package info.degirona.mmartos.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import info.degirona.mmartos.models.Page
import info.degirona.mmartos.models.Page.Cover
import info.degirona.mmartos.models.Page.Details
import info.degirona.mmartos.models.ResumeModel
import info.degirona.mmartos.models.ViewModel
import info.degirona.mmartos.modifiers.relativePointerPosition
import info.degirona.mmartos.modifiers.vignette
import kotlin.math.roundToInt

@Composable
fun ResumeScreen(
    resumeModel: ResumeModel,
    modifier: Modifier = Modifier,
) {
    var viewModel by remember {
        mutableStateOf(
            ViewModel(
                resumeModel = resumeModel,
                activePage = Cover
            )
        )
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Content(
            viewModel = viewModel,
            onUpdateActivePage = { viewModel = viewModel.copy(activePage = it) },
            modifier = Modifier.fillMaxSize(),
        )
        IconButton(
            onClick = { viewModel = viewModel.copy(activePage = Cover) },
            modifier = Modifier
                .align(Alignment.TopStart)
                .scale(1.5f)
                .padding(top = 32.dp, start = 32.dp)
        ) {
            Icon(
                imageVector = if (viewModel.activePage == Cover) Icons.Outlined.Home else Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "Back",
            )
        }
    }
}

@Composable
private fun Content(
    viewModel: ViewModel,
    onUpdateActivePage: (Page) -> Unit,
    modifier: Modifier = Modifier,
) {
    var relativeX by remember { mutableFloatStateOf(0f) }
    var relativeY by remember { mutableFloatStateOf(0f) }
    AnimatedContent(
        targetState = viewModel.activePage,
        modifier = modifier
            .fillMaxSize()
            .vignette(256f, 1.25f, MaterialTheme.colorScheme.background)
            .relativePointerPosition(Unit) { newRelativeX, newRelativeY ->
                relativeX = newRelativeX
                relativeY = newRelativeY
            }
            .graphicsLayer {
                // Rotation are axis-complimentary to coordinate axis
                this.rotationY = 10f * relativeX
                this.rotationX = 10f * relativeY
            }
    ) {
        when (it) {
            is Cover ->
                Container(
                    backgroundHue = 220f,
                    relativeX = relativeX,
                    relativeY = relativeY,
                    block = {
                        Cover(
                            resumeModel = viewModel.resumeModel,
                            modifier = Modifier.fillMaxSize(),
                            onClick = { onUpdateActivePage(Details) },
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                )

            is Details ->
                Container(
                    backgroundHue = 40f,
                    relativeX = relativeX,
                    relativeY = relativeY,
                    block = { Details(modifier = Modifier.fillMaxSize()) },
                    modifier = Modifier.fillMaxSize(),
                )
        }
    }
}

@Composable
private fun Container(
    backgroundHue: Float,
    relativeX: Float,
    relativeY: Float,
    modifier: Modifier = Modifier,
    block: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        GridBackground(
            hue = backgroundHue,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .offset {
                    IntOffset(
                        (40f * relativeX).roundToInt(),
                        -(40f * relativeY).roundToInt()
                    )
                }
        ) {
            block()
        }
    }
}