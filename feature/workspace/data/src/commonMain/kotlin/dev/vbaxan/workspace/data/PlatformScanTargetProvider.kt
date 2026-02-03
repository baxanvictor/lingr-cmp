package dev.vbaxan.workspace.data

import dev.vbaxan.workspace.domain.model.ScanTarget

expect class PlatformScanTargetProvider {
    fun provideScanTargets(): List<ScanTarget>
}