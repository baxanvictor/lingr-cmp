package dev.vbaxan.workspace.domain.model

sealed interface ScanTargetType {
    sealed interface Macos : ScanTargetType {
        data object UserApplications : Macos
        sealed interface UserLibrary : Macos {
            data object ApplicationSupport : UserLibrary
            data object Caches : UserLibrary
            data object Logs : UserLibrary
            data object Preferences : UserLibrary
            data object LaunchAgents : UserLibrary
        }
    }

    sealed interface Linux : ScanTargetType {
        sealed interface User : Linux {
            data object LocalShare : User
            data object Cache : User
            data object Config : User
            data object LocalBin : User
            data object LocalLibs : User
            data object DesktopFiles : User
        }
    }
}