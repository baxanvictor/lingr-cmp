package dev.vbaxan.core.domain.workspace

data class ScanTarget(
    val type: ScanTargetType,
    val path: String,
    val isAdvanced: Boolean = false
)