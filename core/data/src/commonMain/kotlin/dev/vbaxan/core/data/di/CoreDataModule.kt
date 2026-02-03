package dev.vbaxan.core.data.di

import dev.vbaxan.core.data.app.DefaultAppInfoProvider
import dev.vbaxan.core.domain.app.AppInfoProvider
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    factoryOf(::DefaultAppInfoProvider) bind AppInfoProvider::class
}