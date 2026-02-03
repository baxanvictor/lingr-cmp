package dev.vbaxan.core.platform.di

import dev.vbaxan.core.platform.PlatformUtils
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal actual val platformSpecificPlatformModule = module {
    includes(jvmPlatformModule)
    factoryOf(::PlatformUtils)
}