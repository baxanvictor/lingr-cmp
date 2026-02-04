package dev.vbaxan.core.data.di

import dev.vbaxan.core.data.app.DefaultAppInfoProvider
import dev.vbaxan.core.data.settings.InMemoryAppSettingsStorage
import dev.vbaxan.core.domain.app.AppInfoProvider
import dev.vbaxan.core.domain.settings.AppSettingsStorage
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal expect val platformCoreDataModule: Module

val coreDataModule = module {
    includes(platformCoreDataModule)
    singleOf(::InMemoryAppSettingsStorage) bind AppSettingsStorage::class
    factoryOf(::DefaultAppInfoProvider) bind AppInfoProvider::class
}