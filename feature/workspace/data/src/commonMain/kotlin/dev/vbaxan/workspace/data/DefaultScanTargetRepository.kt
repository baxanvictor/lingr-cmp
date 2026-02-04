package dev.vbaxan.workspace.data

import dev.vbaxan.workspace.domain.ScanTargetRepository
import dev.vbaxan.core.domain.workspace.ScanTarget
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class DefaultScanTargetRepository(
    platformScanTargetProvider: PlatformScanTargetProvider
) : ScanTargetRepository {
    private val scanTargets = MutableStateFlow(platformScanTargetProvider.provideScanTargets())

    override fun observeScanTargets(): Flow<List<ScanTarget>> {
        return scanTargets.asStateFlow()
    }
}