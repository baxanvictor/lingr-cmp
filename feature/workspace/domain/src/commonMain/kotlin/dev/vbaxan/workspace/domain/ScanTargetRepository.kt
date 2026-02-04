package dev.vbaxan.workspace.domain

import dev.vbaxan.core.domain.workspace.ScanTarget
import kotlinx.coroutines.flow.Flow

interface ScanTargetRepository {
    fun observeScanTargets(): Flow<List<ScanTarget>>
}