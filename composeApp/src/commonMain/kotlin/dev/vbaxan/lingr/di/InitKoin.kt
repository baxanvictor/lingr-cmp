package dev.vbaxan.lingr.di

import dev.vbaxan.core.data.di.coreDataModule
import dev.vbaxan.core.platform.di.platformCommonModule
import dev.vbaxan.workspace.data.di.workspaceDataModule
import dev.vbaxan.workspace.presentation.di.workspacePresentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            appModule,
            coreDataModule,
            platformCommonModule,
            workspaceDataModule,
            workspacePresentationModule
        )
    }
}