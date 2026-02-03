package dev.vbaxan.workspace.presentation.workspace

import dev.vbaxan.workspace.presentation.model.ScanTargetUi

internal sealed interface WorkspaceAction {
    sealed interface ScanTargets : WorkspaceAction {
        data object OnPickerClick : ScanTargets
        data object OnPickerDismiss : ScanTargets
        data object OnSelectRecommendedTargetsClick : ScanTargets
        data class OnScanTargetClick(val scanTarget: ScanTargetUi) : ScanTargets
    }
}