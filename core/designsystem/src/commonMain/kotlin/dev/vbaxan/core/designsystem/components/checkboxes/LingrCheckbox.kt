package dev.vbaxan.core.designsystem.components.checkboxes

import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import lingr.core.designsystem.generated.resources.Res
import lingr.core.designsystem.generated.resources.ic_checkbox_checked
import lingr.core.designsystem.generated.resources.ic_checkbox_empty
import lingr.core.designsystem.generated.resources.ic_checkbox_undeterminate
import org.jetbrains.compose.resources.vectorResource

@Composable
fun LingrCheckbox(
    selectionMode: LingrCheckboxSelectionMode,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    contentDescription: String? = null
) {
    IconButton(
        modifier = modifier
            .pointerHoverIcon(PointerIcon.Hand)
            .indication(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
        onClick = onClick
    ) {
        val iconRes = when (selectionMode) {
            LingrCheckboxSelectionMode.SELECTED -> Res.drawable.ic_checkbox_checked
            LingrCheckboxSelectionMode.UNSELECTED -> Res.drawable.ic_checkbox_empty
            LingrCheckboxSelectionMode.INDETERMINATE -> Res.drawable.ic_checkbox_undeterminate
        }

        Icon(
            imageVector = vectorResource(iconRes),
            contentDescription = contentDescription,
            tint = color
        )
    }
}