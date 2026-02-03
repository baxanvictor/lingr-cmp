package dev.vbaxan.workspace.data

import dev.vbaxan.core.platform.DesktopOs
import dev.vbaxan.core.platform.PlatformUtils
import dev.vbaxan.workspace.domain.model.ScanTarget
import dev.vbaxan.workspace.domain.model.ScanTargetType

actual class PlatformScanTargetProvider(
    private val platformUtils: PlatformUtils
) {
    actual fun provideScanTargets(): List<ScanTarget> = when (platformUtils.currentOs()) {
        DesktopOs.LINUX -> listOf(
            linuxUserLocalShareScanTarget(),
            linuxUserCacheScanTarget(),
            linuxUserConfigScanTarget(),
            linuxUserLocalBinScanTarget(),
            linuxUserLocalLibsScanTarget(),
            linuxUserDesktopApplicationsScanTarget(),
        )
        DesktopOs.MACOS -> listOf(
            macosUserApplicationsScanTarget(),
            macosUserLibraryApplicationSupportScanTarget(),
            macosUserLibraryCachesScanTarget(),
            macosUserLibraryLogsScanTarget(),
            macosUserLibraryPreferencesScanTarget(),
            macosUserLibraryLaunchAgentsScanTarget(),
        )
        else -> emptyList()
    }
}

private fun linuxUserLocalShareScanTarget() = ScanTarget(
    type = ScanTargetType.Linux.User.LocalShare,
    path = "~/.local/share"
)

private fun linuxUserCacheScanTarget() = ScanTarget(
    type = ScanTargetType.Linux.User.Cache,
    path = "~/.cache"
)

private fun linuxUserConfigScanTarget() = ScanTarget(
    type = ScanTargetType.Linux.User.Config,
    path = "~/.config"
)

private fun linuxUserLocalBinScanTarget() = ScanTarget(
    type = ScanTargetType.Linux.User.LocalBin,
    path = "~/.local/bin",
    isAdvanced = true
)

private fun linuxUserLocalLibsScanTarget() = ScanTarget(
    type = ScanTargetType.Linux.User.LocalLibs,
    path = "~/.local/lib",
    isAdvanced = true
)

private fun linuxUserDesktopApplicationsScanTarget() = ScanTarget(
    type = ScanTargetType.Linux.User.DesktopFiles,
    path = "~/.local/share/applications",
    isAdvanced = true
)

private fun macosUserApplicationsScanTarget() = ScanTarget(
    type = ScanTargetType.Macos.UserApplications,
    path = "~/Applications"
)

private fun macosUserLibraryApplicationSupportScanTarget() = ScanTarget(
    type = ScanTargetType.Macos.UserLibrary.ApplicationSupport,
    path = "~/Library/Application Support"
)

private fun macosUserLibraryCachesScanTarget() = ScanTarget(
    type = ScanTargetType.Macos.UserLibrary.Caches,
    path = "~/Library/Caches"
)

private fun macosUserLibraryLogsScanTarget() = ScanTarget(
    type = ScanTargetType.Macos.UserLibrary.Logs,
    path = "~/Library/Logs"
)

private fun macosUserLibraryPreferencesScanTarget() = ScanTarget(
    type = ScanTargetType.Macos.UserLibrary.Preferences,
    path = "~/Library/Preferences",
    isAdvanced = true
)

private fun macosUserLibraryLaunchAgentsScanTarget() = ScanTarget(
    type = ScanTargetType.Macos.UserLibrary.LaunchAgents,
    path = "~/Library/LaunchAgents",
    isAdvanced = true
)