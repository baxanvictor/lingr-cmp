package dev.vbaxan.core.presentation.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

inline fun <T> Flow<T>.throttleFirst(
    windowDuration: Long,
    crossinline currentTimeMillisProvider: () -> Long
): Flow<T> = flow {
    var lastEmissionTime = 0L

    collect { value ->
        val currentTime = currentTimeMillisProvider()
        if (currentTime - lastEmissionTime >= windowDuration) {
            lastEmissionTime = currentTime
            emit(value)
        }
    }
}