package dev.vbaxan.core.data.settings

import dev.vbaxan.core.domain.workspace.ScanTargetType

expect class DefaultScanTargetsProvider {
    fun provideDefaultScanTargetTypes(): List<ScanTargetType>
}