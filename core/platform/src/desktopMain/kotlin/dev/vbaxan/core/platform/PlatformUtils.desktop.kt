package dev.vbaxan.core.platform

actual class PlatformUtils {
    actual fun currentOs(): OperatingSystem {
        val osName = getOsName()

        return when {
            osName.contains("win", ignoreCase = true) -> DesktopOs.WINDOWS
            osName.contains("mac", ignoreCase = true) -> DesktopOs.MACOS
            else -> DesktopOs.LINUX
        }
    }

    actual fun getOsName(): String {
        return System.getProperty("os.name")
    }

    actual fun getAppVersion(): String {
        return BuildKonfig.DESKTOP_APP_VERSION
    }
}