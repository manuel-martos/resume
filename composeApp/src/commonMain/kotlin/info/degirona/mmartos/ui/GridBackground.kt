package info.degirona.mmartos.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.isActive
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.time.DurationUnit
import kotlin.time.TimeSource

@Composable
fun GridBackground(
    maxCols: Int,
    hue: Float,
    modifier: Modifier = Modifier,
) {
    var elapsedTime by remember { mutableDoubleStateOf(0.0) }
    LaunchedEffect(Unit) {
        val clock = TimeSource.Monotonic.markNow()
        while (isActive) {
            withFrameMillis {
                elapsedTime = clock.elapsedNow().toDouble(DurationUnit.SECONDS)
            }
        }
    }

    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val rectAspectRatio = 16f / 9f
        val rectWidth = size.width / maxCols
        val rectHeight = rectWidth / rectAspectRatio
        val maxRows = (size.height / rectHeight).roundToInt() + 1
        for (rowIdx in -maxRows..maxRows) {
            for (colIdx in -maxCols..maxCols) {
                val cs = cos(0.3 * elapsedTime)
                val sn = sin(0.3 * elapsedTime)
                val newRow = rowIdx * cs - colIdx * sn
                val newCol = rowIdx * sn + colIdx * cs
                drawRoundRect(
                    color = Color
                        .hsv(
                            hue = hue,
                            saturation = 0.5f + 0.5f * sin(newRow + newCol).toFloat(),
                            value = 0.5f + 0.5f * cos(newRow - newCol).toFloat(),
                        )
                        .copy(alpha = 0.125f + 0.125f * cos(newRow - newCol).toFloat()),
                    topLeft = Offset(
                        x = size.center.x + colIdx * rectWidth - rectWidth / 2f,
                        y = size.center.y + rowIdx * rectHeight - rectHeight / 2f,
                    ),
                    size = Size(rectWidth, rectHeight).times(0.9f),
                    cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx()),
                )
            }
        }
    }
}
