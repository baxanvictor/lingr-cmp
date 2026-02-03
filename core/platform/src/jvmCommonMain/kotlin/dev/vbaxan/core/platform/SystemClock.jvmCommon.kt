package dev.vbaxan.core.platform

actual class SystemClock {
    actual fun currentTimeMillis(): Long {
        return System.currentTimeMillis()
    }
}