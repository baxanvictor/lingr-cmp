package dev.vbaxan.workspace.presentation.workspace.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.vbaxan.core.designsystem.components.icons.RotatingIcon
import dev.vbaxan.workspace.presentation.mappers.toPillData
import dev.vbaxan.workspace.presentation.model.ScanTargetUi
import dev.vbaxan.workspace.presentation.workspace.paneScaffoldDirectiveMaxHorizontalPartitions
import lingr.feature.workspace.presentation.generated.resources.Res
import lingr.feature.workspace.presentation.generated.resources.keyboard_down_icon
import lingr.feature.workspace.presentation.generated.resources.plus_x_more
import lingr.feature.workspace.presentation.generated.resources.scan_targets
import lingr.feature.workspace.presentation.generated.resources.scanning
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun ScanTargetsPopupTrigger(
    selectedScanTargets: List<ScanTargetUi>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isArrowIconRotated: Boolean = false,
) {
    val maxHorizontalPartitions = paneScaffoldDirectiveMaxHorizontalPartitions()

    val pillsToShowCount = when (maxHorizontalPartitions) {
        1 -> 1
        else -> 2
    }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        onClick = onClick,
        interactionSource = remember { MutableInteractionSource() },
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(
                    vertical = 8.dp
                )
                .padding(
                    start = 16.dp,
                    end = 10.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val scanTargetsTextRes = if (selectedScanTargets.isNotEmpty()) {
                Res.string.scanning
            } else {
                Res.string.scan_targets
            }

            Text(
                text = stringResource(scanTargetsTextRes),
                style = MaterialTheme.typography.labelMedium,
            )

            if (selectedScanTargets.isNotEmpty()) {
                selectedScanTargets
                    .take(pillsToShowCount)
                    .map { scanTarget ->
                        ScanTargetPill(
                            pillData = scanTarget.toPillData()
                        )
                    }
                val remainingTargetsCount = selectedScanTargets.size - pillsToShowCount
                if (remainingTargetsCount > 0) {
                    Text(
                        text = stringResource(
                            resource = Res.string.plus_x_more,
                            formatArgs = arrayOf(remainingTargetsCount)
                        ),
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            RotatingIcon(
                imageVector = vectorResource(Res.drawable.keyboard_down_icon),
                isRotated = isArrowIconRotated,
                iconSize = 16.dp
            )
        }
    }
}