package dev.vbaxan.workspace.presentation.navigation

import dev.vbaxan.core.presentation.navigation.Route
import kotlinx.serialization.Serializable

@Serializable
data object WorkspaceRoute : Route {
    @Serializable
    data object Workspace : Route
}
