package dev.vbaxan.workspace.presentation.mappers

import androidx.compose.runtime.Composable
import dev.vbaxan.workspace.presentation.model.ScanTargetPillData
import dev.vbaxan.workspace.presentation.model.ScanTargetUi

@Composable
internal fun ScanTargetUi.toPillData(): ScanTargetPillData {
    return ScanTargetPillData(
        title = title
    )
}