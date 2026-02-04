package dev.vbaxan.workspace.presentation.workspace

import dev.vbaxan.workspace.presentation.model.ScanTargetUi

internal data class WorkspaceState(
    val scanTargets: ScanTargetsState = ScanTargetsState(),
    val appInfo: AppInfoState = AppInfoState()
)

internal data class ScanTargetsState(
    val scanTargets: List<ScanTargetUi> = emptyList(),
    val selectedScanTargets: List<ScanTargetUi> = emptyList(),
    val isPickerShowing: Boolean = false
) {
    val recommendedScanTargets: List<ScanTargetUi>
        get() = scanTargets.filterNot { it.isAdvanced }

    val advancedScanTargets: List<ScanTargetUi>
        get() = scanTargets.filter { it.isAdvanced }

    val hasSelectedScanTargets: Boolean
        get() = selectedScanTargets.isNotEmpty()

    fun isScanTargetSelected(scanTarget: ScanTargetUi): Boolean {
        return selectedScanTargets.any { it.type == scanTarget.type }
    }
}

internal data class AppInfoState(
    val appName: String = ""
)
