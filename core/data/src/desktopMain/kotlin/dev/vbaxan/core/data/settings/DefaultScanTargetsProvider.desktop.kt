package dev.vbaxan.core.data.settings

import dev.vbaxan.core.domain.workspace.ScanTargetType
import dev.vbaxan.core.platform.DesktopOs
import dev.vbaxan.core.platform.PlatformUtils

actual class DefaultScanTargetsProvider(
    private val platformUtils: PlatformUtils
) {
    actual fun provideDefaultScanTargetTypes(): List<ScanTargetType> {
        return when (platformUtils.currentOs()) {
            DesktopOs.LINUX -> listOf(
                ScanTargetType.Linux.User.LocalShare,
                ScanTargetType.Linux.User.Cache,
                ScanTargetType.Linux.User.Config,
            )

            DesktopOs.MACOS -> listOf(
                ScanTargetType.Macos.UserLibrary.ApplicationSupport,
                ScanTargetType.Macos.UserLibrary.Caches,
                ScanTargetType.Macos.UserLibrary.Logs,
            )

            else -> emptyList()
        }
    }
}