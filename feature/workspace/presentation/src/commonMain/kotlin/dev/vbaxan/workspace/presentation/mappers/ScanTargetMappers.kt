package dev.vbaxan.workspace.presentation.mappers

import dev.vbaxan.core.presentation.util.UiText
import dev.vbaxan.core.domain.workspace.ScanTarget
import dev.vbaxan.core.domain.workspace.ScanTargetType
import dev.vbaxan.workspace.presentation.model.ScanTargetUi
import lingr.feature.workspace.presentation.generated.resources.Res
import lingr.feature.workspace.presentation.generated.resources.application_support
import lingr.feature.workspace.presentation.generated.resources.application_support_desc
import lingr.feature.workspace.presentation.generated.resources.autostart_entries
import lingr.feature.workspace.presentation.generated.resources.autostart_entries_desc
import lingr.feature.workspace.presentation.generated.resources.cache
import lingr.feature.workspace.presentation.generated.resources.cache_desc
import lingr.feature.workspace.presentation.generated.resources.caches
import lingr.feature.workspace.presentation.generated.resources.caches_desc
import lingr.feature.workspace.presentation.generated.resources.config
import lingr.feature.workspace.presentation.generated.resources.config_desc
import lingr.feature.workspace.presentation.generated.resources.desktop_files
import lingr.feature.workspace.presentation.generated.resources.desktop_files_desc
import lingr.feature.workspace.presentation.generated.resources.launch_agents
import lingr.feature.workspace.presentation.generated.resources.launch_agents_desc
import lingr.feature.workspace.presentation.generated.resources.local_bin
import lingr.feature.workspace.presentation.generated.resources.local_bin_desc
import lingr.feature.workspace.presentation.generated.resources.local_libs
import lingr.feature.workspace.presentation.generated.resources.local_libs_desc
import lingr.feature.workspace.presentation.generated.resources.local_share
import lingr.feature.workspace.presentation.generated.resources.local_share_desc
import lingr.feature.workspace.presentation.generated.resources.logs
import lingr.feature.workspace.presentation.generated.resources.logs_desc
import lingr.feature.workspace.presentation.generated.resources.preferences
import lingr.feature.workspace.presentation.generated.resources.preferences_desc
import lingr.feature.workspace.presentation.generated.resources.saved_application_state
import lingr.feature.workspace.presentation.generated.resources.saved_application_state_desc
import lingr.feature.workspace.presentation.generated.resources.user_applications
import lingr.feature.workspace.presentation.generated.resources.user_applications_desc
import org.jetbrains.compose.resources.StringResource

internal fun ScanTarget.toUi(): ScanTargetUi {
    val titleRes: StringResource
    val descriptionRes: StringResource

    when (type) {
        ScanTargetType.Macos.UserApplications -> {
            titleRes = Res.string.user_applications
            descriptionRes = Res.string.user_applications_desc
        }

        ScanTargetType.Macos.UserLibrary.ApplicationSupport -> {
            titleRes = Res.string.application_support
            descriptionRes = Res.string.application_support_desc
        }

        ScanTargetType.Macos.UserLibrary.Caches -> {
            titleRes = Res.string.caches
            descriptionRes = Res.string.caches_desc
        }

        ScanTargetType.Macos.UserLibrary.Logs -> {
            titleRes = Res.string.logs
            descriptionRes = Res.string.logs_desc
        }

        ScanTargetType.Macos.UserLibrary.Preferences -> {
            titleRes = Res.string.preferences
            descriptionRes = Res.string.preferences_desc
        }

        ScanTargetType.Macos.UserLibrary.LaunchAgents -> {
            titleRes = Res.string.launch_agents
            descriptionRes = Res.string.launch_agents_desc
        }

        ScanTargetType.Macos.UserLibrary.SavedApplicationState -> {
            titleRes = Res.string.saved_application_state
            descriptionRes = Res.string.saved_application_state_desc
        }

        ScanTargetType.Linux.User.LocalShare -> {
            titleRes = Res.string.local_share
            descriptionRes = Res.string.local_share_desc
        }

        ScanTargetType.Linux.User.Cache -> {
            titleRes = Res.string.cache
            descriptionRes = Res.string.cache_desc
        }

        ScanTargetType.Linux.User.Config -> {
            titleRes = Res.string.config
            descriptionRes = Res.string.config_desc
        }

        ScanTargetType.Linux.User.LocalBin -> {
            titleRes = Res.string.local_bin
            descriptionRes = Res.string.local_bin_desc
        }

        ScanTargetType.Linux.User.LocalLibs -> {
            titleRes = Res.string.local_libs
            descriptionRes = Res.string.local_libs_desc
        }

        ScanTargetType.Linux.User.DesktopFiles -> {
            titleRes = Res.string.desktop_files
            descriptionRes = Res.string.desktop_files_desc
        }

        ScanTargetType.Linux.User.AutostartEntries -> {
            titleRes = Res.string.autostart_entries
            descriptionRes = Res.string.autostart_entries_desc
        }
    }

    return ScanTargetUi(
        type = type,
        title = UiText.Resource(titleRes),
        path = path,
        description = UiText.Resource(descriptionRes),
        isAdvanced = isAdvanced
    )
}