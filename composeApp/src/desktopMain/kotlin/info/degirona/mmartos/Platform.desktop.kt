package info.degirona.mmartos

actual fun calcElapsedTime(prevElapsedTime: Double, frameMillis: Long): Double =
    prevElapsedTime + frameMillis.toDouble() / 100_000_000_000
