package dev.vbaxan.workspace.presentation.workspace.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.vbaxan.core.designsystem.components.checkboxes.LingrCheckbox
import dev.vbaxan.core.designsystem.components.checkboxes.LingrCheckboxSelectionMode
import dev.vbaxan.core.designsystem.theme.extended
import dev.vbaxan.workspace.presentation.model.ScanTargetUi
import lingr.feature.workspace.presentation.generated.resources.Res
import lingr.feature.workspace.presentation.generated.resources.may_affect_app_behavior_if_removed
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun ScanTargetListItem(
    scanTarget: ScanTargetUi,
    textWidth: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textWidthDp = with(LocalDensity.current) { textWidth.toDp() }

    Row(
        modifier = modifier
            .background(
                color = if (isSelected) {
                    MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.45f)
                } else {
                    Color.Transparent
                }
            )
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() }
            )
            .pointerHoverIcon(PointerIcon.Hand)
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column {
            LingrCheckbox(
                modifier = Modifier.size(24.dp),
                selectionMode = if (isSelected) {
                    LingrCheckboxSelectionMode.SELECTED
                } else {
                    LingrCheckboxSelectionMode.UNSELECTED
                },
                onClick = onClick
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = scanTarget.title.asString(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.width(textWidthDp)
            )
            Text(
                text = scanTarget.path,
                style = MaterialTheme.typography.extended.monoLabelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(textWidthDp)
            )
            Text(
                text = scanTarget.description.asString(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(textWidthDp)
            )
            if (scanTarget.isAdvanced) {
                Text(
                    text = stringResource(Res.string.may_affect_app_behavior_if_removed),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(textWidthDp)
                )
            }
        }
    }
}