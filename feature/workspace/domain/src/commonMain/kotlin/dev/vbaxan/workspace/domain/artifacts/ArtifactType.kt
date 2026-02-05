package dev.vbaxan.workspace.domain.artifacts

sealed interface ArtifactType {
    data object App : ArtifactType
    data object StartupEntry : ArtifactType
    data object DesktopEntry : ArtifactType
    data object StandaloneBinary : ArtifactType
}