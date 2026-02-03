package dev.vbaxan.workspace.presentation.workspace.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import dev.vbaxan.core.designsystem.components.checkboxes.LingrCheckbox
import dev.vbaxan.core.designsystem.components.checkboxes.LingrCheckboxSelectionMode
import dev.vbaxan.core.designsystem.components.checkboxes.isUnselected
import lingr.feature.workspace.presentation.generated.resources.Res
import lingr.feature.workspace.presentation.generated.resources.select_recommended_targets
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun SelectRecommendedTargetsListItem(
    onClick: () -> Unit,
    selectionMode: LingrCheckboxSelectionMode,
    textWidth: Int,
    modifier: Modifier = Modifier
) {
    val textWidthDp = with(LocalDensity.current) { textWidth.toDp() }

    Row(
        modifier = modifier
            .background(
                color = if (selectionMode.isUnselected) {
                    Color.Transparent
                } else {
                    MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.45f)
                }
            )
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() }
            )
            .pointerHoverIcon(PointerIcon.Hand)
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LingrCheckbox(
            modifier = Modifier.size(24.dp),
            selectionMode = selectionMode,
            onClick = onClick
        )
        Text(
            text = stringResource(Res.string.select_recommended_targets),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.width(textWidthDp)
        )
    }
}
