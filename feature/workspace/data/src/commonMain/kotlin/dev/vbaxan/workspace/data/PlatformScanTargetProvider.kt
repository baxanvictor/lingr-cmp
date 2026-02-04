package dev.vbaxan.workspace.data

import dev.vbaxan.core.domain.workspace.ScanTarget

expect class PlatformScanTargetProvider {
    fun provideScanTargets(): List<ScanTarget>
}