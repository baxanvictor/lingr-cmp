package dev.vbaxan.core.platform.di

import dev.vbaxan.core.platform.SystemClock
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val jvmPlatformModule = module {
    factoryOf(::SystemClock)
}