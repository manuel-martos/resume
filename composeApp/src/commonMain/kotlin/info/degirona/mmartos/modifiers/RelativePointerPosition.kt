package info.degirona.mmartos.modifiers

import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

fun Modifier.relativePointerPosition(
    key1: Any?,
    block: (Float, Float) -> Unit
): Modifier =
    this then pointerInput(key1) {
        val width = size.width.toFloat()
        val height = size.height.toFloat()
        val halfWidth = width / 2f
        val halfHeight = height / 2f
        while (true) {
            this.awaitPointerEventScope {
                val event = this.awaitPointerEvent()
                val position = event.changes.first().position
                val relativeX = ((position.x - halfWidth) / width).coerceIn(-1f, 1f)
                val relativeY = ((position.y - halfHeight) / height).coerceIn(-1f, 1f)
                block(relativeX, relativeY)
            }
        }
    }
