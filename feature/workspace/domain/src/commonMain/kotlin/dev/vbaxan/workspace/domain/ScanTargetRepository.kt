package dev.vbaxan.workspace.domain

import dev.vbaxan.workspace.domain.model.ScanTarget
import kotlinx.coroutines.flow.Flow

interface ScanTargetRepository {
    fun observeScanTargets(): Flow<List<ScanTarget>>
}