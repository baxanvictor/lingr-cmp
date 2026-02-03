package dev.vbaxan.workspace.data.di

import dev.vbaxan.workspace.data.PlatformScanTargetProvider
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal actual val platformWorkspaceDataModule = module {
    factoryOf(::PlatformScanTargetProvider)
}