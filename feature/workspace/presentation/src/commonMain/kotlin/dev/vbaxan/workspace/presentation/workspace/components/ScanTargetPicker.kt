package dev.vbaxan.workspace.presentation.workspace.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import dev.vbaxan.core.designsystem.components.popups.LingrPopup
import dev.vbaxan.core.designsystem.components.popups.PopupTopBarVariant
import dev.vbaxan.core.designsystem.theme.extended
import dev.vbaxan.core.presentation.util.UiText
import dev.vbaxan.workspace.presentation.mappers.toCheckboxSelectionMode
import dev.vbaxan.workspace.presentation.model.RecommendedTargetsSelection
import dev.vbaxan.workspace.presentation.model.ScanTargetUi
import dev.vbaxan.workspace.presentation.workspace.ScanTargetsState
import lingr.feature.workspace.presentation.generated.resources.Res
import lingr.feature.workspace.presentation.generated.resources.advanced
import lingr.feature.workspace.presentation.generated.resources.scan_targets
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun ScanTargetPicker(
    scanTargetsState: ScanTargetsState,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    recommendedTargetsSelection: RecommendedTargetsSelection,
    onSelectRecommendedTargetsClick: () -> Unit,
    onScanTargetItemClick: (ScanTargetUi) -> Unit,
    modifier: Modifier = Modifier,
) {
    LingrPopup(
        onDismiss = onDismiss,
        popupTrigger = {
            ScanTargetsPopupTrigger(
                selectedScanTargets = scanTargetsState.selectedScanTargets,
                onClick = onClick,
                isArrowIconRotated = scanTargetsState.isPickerShowing
            )
        },
        popupContent = {
            val titles = mutableListOf<String>()
            val paths = mutableListOf<String>()
            val descriptions = mutableListOf<String>()

            for (scanTarget in scanTargetsState.scanTargets) {
                titles.add(scanTarget.title.asString())
                paths.add(scanTarget.path)
                descriptions.add(scanTarget.description.asString())
            }

            val advancedTitle = stringResource(Res.string.advanced)

            val titleStyle = MaterialTheme.typography.bodySmall
            val pathStyle = MaterialTheme.typography.extended.monoLabelSmall
            val descriptionStyle = MaterialTheme.typography.bodySmall
            val advancedTitleStyle = MaterialTheme.typography.labelMedium

            val textMeasurer = rememberTextMeasurer()

            val maxTextWidth = remember(titles, paths, descriptions, LocalDensity.current) {
                listOf(
                    titles.maxOf { title ->
                        textMeasurer.measure(
                            text = title,
                            style = titleStyle
                        ).size.width
                    },
                    paths.maxOf { path ->
                        textMeasurer.measure(
                            text = path,
                            style = pathStyle
                        ).size.width
                    },
                    descriptions.maxOf { description ->
                        textMeasurer.measure(
                            text = description,
                            style = descriptionStyle
                        ).size.width
                    },
                    textMeasurer.measure(
                        text = advancedTitle,
                        style = advancedTitleStyle
                    ).size.width
                ).maxOf { it }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                SelectRecommendedTargetsListItem(
                    onClick = onSelectRecommendedTargetsClick,
                    textWidth = maxTextWidth,
                    selectionMode = recommendedTargetsSelection.toCheckboxSelectionMode()
                )

                scanTargetsState.recommendedScanTargets.map { scanTarget ->
                    ScanTargetListItem(
                        scanTarget = scanTarget,
                        textWidth = maxTextWidth,
                        isSelected = scanTargetsState.isScanTargetSelected(scanTarget),
                        onClick = {
                            onScanTargetItemClick(scanTarget)
                        }
                    )
                }

                if (scanTargetsState.advancedScanTargets.isNotEmpty()) {
                    Text(
                        text = advancedTitle,
                        style = advancedTitleStyle,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            )
                    )
                    scanTargetsState.advancedScanTargets.map { scanTarget ->
                        ScanTargetListItem(
                            scanTarget = scanTarget,
                            textWidth = maxTextWidth,
                            isSelected = scanTargetsState.isScanTargetSelected(scanTarget),
                            onClick = {
                                onScanTargetItemClick(scanTarget)
                            },
                        )
                    }
                }
            }
        },
        modifier = modifier,
        topBarVariant = PopupTopBarVariant.TitleWithCloseButton(
            title = UiText.Resource(Res.string.scan_targets)
        ),
        isOpen = scanTargetsState.isPickerShowing
    )
}
