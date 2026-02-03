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

@Composable
internal fun ScanTargetListItem(
    scanTarget: ScanTargetUi,
    textWidth: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textWidthDp = with(LocalDensity.current) { textWidth.toDp() }

    Column(
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
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            LingrCheckbox(
                modifier = Modifier.size(24.dp),
                selectionMode = if (isSelected) {
                    LingrCheckboxSelectionMode.SELECTED
                } else {
                    LingrCheckboxSelectionMode.UNSELECTED
                },
                onClick = onClick
            )
            Text(
                text = scanTarget.title.asString(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.width(textWidthDp)
            )
        }
        Row {
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = scanTarget.path,
                style = MaterialTheme.typography.extended.monoLabelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(textWidthDp)
            )
        }
        Row{
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = scanTarget.description.asString(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(textWidthDp)
            )
        }
    }
}