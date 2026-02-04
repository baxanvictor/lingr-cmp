package dev.vbaxan.core.data.di

import dev.vbaxan.core.data.settings.DefaultScanTargetsProvider
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal actual val platformCoreDataModule = module {
    factoryOf(::DefaultScanTargetsProvider)
}