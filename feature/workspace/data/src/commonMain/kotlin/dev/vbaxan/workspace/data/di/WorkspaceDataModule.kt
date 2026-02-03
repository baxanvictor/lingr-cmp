package dev.vbaxan.workspace.data.di

import dev.vbaxan.workspace.data.DefaultScanTargetRepository
import dev.vbaxan.workspace.domain.ScanTargetRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal expect val platformWorkspaceDataModule: Module

val workspaceDataModule = module {
    includes(platformWorkspaceDataModule)
    factoryOf(::DefaultScanTargetRepository) bind ScanTargetRepository::class
}