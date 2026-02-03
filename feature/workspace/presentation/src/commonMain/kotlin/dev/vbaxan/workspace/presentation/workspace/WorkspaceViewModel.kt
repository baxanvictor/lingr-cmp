package dev.vbaxan.workspace.presentation.workspace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vbaxan.core.domain.app.AppInfoProvider
import dev.vbaxan.core.platform.SystemClock
import dev.vbaxan.core.presentation.util.throttleFirst
import dev.vbaxan.workspace.domain.ScanTargetRepository
import dev.vbaxan.workspace.presentation.mappers.toUi
import dev.vbaxan.workspace.presentation.model.RecommendedTargetsSelection
import dev.vbaxan.workspace.presentation.model.ScanTargetUi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class WorkspaceViewModel(
    private val appInfoProvider: AppInfoProvider,
    private val scanTargetRepository: ScanTargetRepository,
    private val systemClock: SystemClock
) : ViewModel() {
    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(WorkspaceState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                initAppInfo()
                observeToggleScanTargetsIsShowingEvents()
                observeScanTargets()
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = WorkspaceState()
        )

    private val toggleScanTargetsPickerIsShowingEvents = MutableSharedFlow<Boolean>(1)

    fun onAction(action: WorkspaceAction) {
        when (action) {
            WorkspaceAction.ScanTargets.OnPickerClick -> toggleScanTargetsPickerIsShowing(true)
            WorkspaceAction.ScanTargets.OnPickerDismiss -> toggleScanTargetsPickerIsShowing(false)
            WorkspaceAction.ScanTargets.OnSelectRecommendedTargetsClick -> toggleRecommendedTargetsSelection()
            is WorkspaceAction.ScanTargets.OnScanTargetClick -> toggleScanTargetIsSelected(action.scanTarget)
        }
    }

    fun recommendedTargetsSelection(): RecommendedTargetsSelection {
        val scanTargetsState = _state.value.scanTargets
        val recommendedTargetsSelectedCount = scanTargetsState.recommendedScanTargets.count { recommendedTarget ->
            scanTargetsState.selectedScanTargets.any { recommendedTarget.type == it.type }
        }
        return when (recommendedTargetsSelectedCount) {
            scanTargetsState.recommendedScanTargets.size -> RecommendedTargetsSelection.ALL
            0 -> RecommendedTargetsSelection.NONE
            else -> RecommendedTargetsSelection.SOME
        }
    }

    private fun initAppInfo() {
        _state.update { it.copy(
            appInfo = it.appInfo.copy(
                appName = appInfoProvider.provideAppName()
            )
        ) }
    }

    private fun observeToggleScanTargetsIsShowingEvents() {
        toggleScanTargetsPickerIsShowingEvents
            .throttleFirst(
                windowDuration = 300L,
                currentTimeMillisProvider = { systemClock.currentTimeMillis() }
            )
            .onEach { isShowing ->
                if (_state.value.scanTargets.isPickerShowing != isShowing) {
                    updateScanTargetsState { scanTargetsState ->
                        scanTargetsState.copy(
                            isPickerShowing = isShowing
                        )
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun observeScanTargets() {
        scanTargetRepository
            .observeScanTargets()
            .onEach { scanTargets ->
                updateScanTargetsState { scanTargetsState ->
                    scanTargetsState.copy(
                        scanTargets = scanTargets.map { it.toUi() }
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    private fun toggleScanTargetsPickerIsShowing(isShowing: Boolean) {
        viewModelScope.launch {
            toggleScanTargetsPickerIsShowingEvents.emit(isShowing)
        }
    }

    private fun toggleRecommendedTargetsSelection() {
        when (recommendedTargetsSelection()) {
            RecommendedTargetsSelection.NONE -> updateScanTargetsState { scanTargetsState ->
                scanTargetsState.copy(
                    selectedScanTargets = scanTargetsState.recommendedScanTargets
                )
            }
            else -> updateScanTargetsState { scanTargetsState ->
                scanTargetsState.copy(
                    selectedScanTargets = emptyList()
                )
            }
        }
    }

    private fun toggleScanTargetIsSelected(scanTarget: ScanTargetUi) {
        val selectedScanTarget = _state.value.scanTargets.selectedScanTargets.find { it.type == scanTarget.type }
        updateScanTargetsState { scanTargetsState ->
            scanTargetsState.copy(
                selectedScanTargets = if (selectedScanTarget != null) {
                    scanTargetsState.selectedScanTargets.minus(selectedScanTarget)
                } else {
                    scanTargetsState.selectedScanTargets.plus(scanTarget)
                }
            )
        }
    }

    private fun updateScanTargetsState(updater: (ScanTargetsState) -> ScanTargetsState) {
        _state.update { it.copy(
            scanTargets = updater(it.scanTargets)
        ) }
    }
}