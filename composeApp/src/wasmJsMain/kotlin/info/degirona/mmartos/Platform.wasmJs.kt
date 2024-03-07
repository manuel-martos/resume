package info.degirona.mmartos

actual fun calcElapsedTime(prevElapsedTime: Double, frameMillis: Long): Double =
    frameMillis.toDouble() / 1_000
