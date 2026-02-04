package dev.vbaxan.workspace.presentation.workspace.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import dev.vbaxan.core.designsystem.components.brand.LingrHorizontalDivider
import dev.vbaxan.core.designsystem.components.buttons.LingrOutlinedIconButton
import dev.vbaxan.core.designsystem.components.tooltips.ComposableWithTooltip
import dev.vbaxan.core.designsystem.theme.extended
import dev.vbaxan.workspace.presentation.model.RecommendedTargetsSelection
import dev.vbaxan.workspace.presentation.model.ScanTargetUi
import dev.vbaxan.workspace.presentation.workspace.ScanTargetsState
import lingr.feature.workspace.presentation.generated.resources.Res
import lingr.feature.workspace.presentation.generated.resources.ic_scan
import lingr.feature.workspace.presentation.generated.resources.ic_settings
import lingr.feature.workspace.presentation.generated.resources.scan
import lingr.feature.workspace.presentation.generated.resources.select_at_least_one_target_to_scan
import lingr.feature.workspace.presentation.generated.resources.settings
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun WorkspaceTopAppBar(
    appName: String,
    actionArgs: ActionArgs,
    scanTargetsArgs: ScanTargetsArgs,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = appName,
                style = MaterialTheme.typography.extended.topBarTitle,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val canScan = scanTargetsArgs.scanTargetsState.hasSelectedScanTargets
                    ComposableWithTooltip(
                        tooltipText = if (canScan) {
                            stringResource(Res.string.scan)
                        } else {
                            stringResource(Res.string.select_at_least_one_target_to_scan)
                        },
                        modifier = Modifier
                            .pointerHoverIcon(PointerIcon.Hand)
                    ) {
                        LingrOutlinedIconButton(
                            onClick = actionArgs.onScanClick,
                            enabled = canScan
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = vectorResource(Res.drawable.ic_scan),
                                contentDescription = stringResource(Res.string.scan)
                            )
                        }
                    }

                    ComposableWithTooltip(
                        tooltipText = stringResource(Res.string.settings),
                        modifier = Modifier
                            .pointerHoverIcon(PointerIcon.Hand)
                    ) {
                        LingrOutlinedIconButton(
                            onClick = actionArgs.onSettingsClick
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = vectorResource(Res.drawable.ic_settings),
                                contentDescription = stringResource(Res.string.settings)
                            )
                        }
                    }
                }

                ScanTargetPicker(
                    scanTargetsState = scanTargetsArgs.scanTargetsState,
                    recommendedTargetsSelection = scanTargetsArgs.recommendedTargetsSelection,
                    onClick = scanTargetsArgs.onScanTargetsPickerClick,
                    onDismiss = scanTargetsArgs.onScanTargetsPickerDismiss,
                    onSelectRecommendedTargetsClick = scanTargetsArgs.onSelectRecommendedTargetsClick,
                    onScanTargetItemClick = scanTargetsArgs.onScanTargetItemClick
                )
            }
        }

        LingrHorizontalDivider(
            transparency = 0.1f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Immutable
internal data class ActionArgs(
    val onScanClick: () -> Unit,
    val onSettingsClick: () -> Unit
)

@Immutable
internal data class ScanTargetsArgs(
    val scanTargetsState: ScanTargetsState,
    val recommendedTargetsSelection: RecommendedTargetsSelection,
    val onScanTargetsPickerClick: () -> Unit,
    val onScanTargetsPickerDismiss: () -> Unit,
    val onSelectRecommendedTargetsClick: () -> Unit,
    val onScanTargetItemClick: (ScanTargetUi) -> Unit,
)