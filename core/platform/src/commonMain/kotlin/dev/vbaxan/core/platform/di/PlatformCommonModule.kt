package dev.vbaxan.core.platform.di

import org.koin.core.module.Module
import org.koin.dsl.module

internal expect val platformSpecificPlatformModule: Module

val platformCommonModule = module {
    includes(platformSpecificPlatformModule)
}