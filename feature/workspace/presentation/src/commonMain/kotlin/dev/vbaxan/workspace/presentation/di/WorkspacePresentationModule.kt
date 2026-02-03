package dev.vbaxan.workspace.presentation.di

import dev.vbaxan.workspace.presentation.workspace.WorkspaceViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val workspacePresentationModule = module {
    viewModelOf(::WorkspaceViewModel)
}