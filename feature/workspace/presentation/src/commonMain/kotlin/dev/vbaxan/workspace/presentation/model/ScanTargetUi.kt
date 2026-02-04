package dev.vbaxan.workspace.presentation.model

import dev.vbaxan.core.presentation.util.UiText
import dev.vbaxan.core.domain.workspace.ScanTargetType

data class ScanTargetUi(
    val type: ScanTargetType,
    val title: UiText,
    val path: String,
    val description: UiText,
    val isAdvanced: Boolean
)