package dev.vbaxan.core.domain.settings

import dev.vbaxan.core.domain.workspace.ScanTargetType

data class AppSettings(
    val defaultScanTargetTypes: List<ScanTargetType>
)