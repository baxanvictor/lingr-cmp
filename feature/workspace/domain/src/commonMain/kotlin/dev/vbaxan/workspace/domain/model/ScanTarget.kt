package dev.vbaxan.workspace.domain.model

data class ScanTarget(
    val type: ScanTargetType,
    val path: String,
    val isAdvanced: Boolean = false
)