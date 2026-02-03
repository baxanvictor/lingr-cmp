package dev.vbaxan.core.platform

expect class SystemClock {
    fun currentTimeMillis(): Long
}